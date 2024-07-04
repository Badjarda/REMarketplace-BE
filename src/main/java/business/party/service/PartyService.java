package business.party.service;

import com.daml.ledger.api.v1.admin.PartyManagementServiceGrpc;
import com.daml.ledger.api.v1.admin.PartyManagementServiceGrpc.PartyManagementServiceFutureStub;
import com.daml.ledger.api.v1.admin.PartyManagementServiceOuterClass;
import com.daml.ledger.api.v1.admin.PartyManagementServiceOuterClass.AllocatePartyResponse;
import com.daml.ledger.api.v1.admin.PartyManagementServiceOuterClass.ListKnownPartiesRequest;
import com.daml.ledger.api.v1.admin.PartyManagementServiceOuterClass.ListKnownPartiesResponse;
import com.daml.ledger.api.v1.admin.PartyManagementServiceOuterClass.PartyDetails;

import business.party.entity.model.Party;
import business.party.entity.repository.PartyRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.concurrent.ExecutionException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@ApplicationScoped
public class PartyService {
    @Inject
    PartyRepository partyRepository;

    private ManagedChannel channel;

    private PartyManagementServiceFutureStub stub;

    public PartyService() {
        channel = ManagedChannelBuilder.forAddress("localhost", 6865).usePlaintext().build();
        stub = PartyManagementServiceGrpc.newFutureStub(channel);
    }

    public String createParty(String partyName) {
        AllocatePartyResponse partyResponse;
        String partyId;
        try {
            partyResponse = alloc(partyName, true);
            partyId = partyResponse.getPartyDetails().getParty();

        } catch (ExecutionException e) {
            e.printStackTrace();
            return "error execution\n";
        } catch (InterruptedException e) {
            return "interruption error\n";
        }
        partyRepository.persist(new Party(partyName, partyId));
        return "Party " + partyName + " Successfully created!\n";
    }

    public PartyManagementServiceOuterClass.AllocatePartyResponse alloc(String party, boolean withPartyHint)
            throws ExecutionException, InterruptedException {

        PartyManagementServiceOuterClass.AllocatePartyResponse response;
        if (withPartyHint) {
            response = stub.allocateParty(PartyManagementServiceOuterClass.AllocatePartyRequest.newBuilder()
                    .setDisplayName(party).setPartyIdHint(party).build()).get();
        } else {
            response = stub
                    .allocateParty(PartyManagementServiceOuterClass.AllocatePartyRequest.newBuilder()
                            .setDisplayName(party).build())
                    .get();
        }
        return response;
    }

    public void storeAllPartiesFromLedger() {
        ListKnownPartiesResponse response;
        try {
            response = stub.listKnownParties(ListKnownPartiesRequest.newBuilder().build()).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return;
        }
        for (PartyDetails party : response.getPartyDetailsList()) {
            partyRepository.persist(new Party(party.getDisplayName(), party.getParty()));

        }
    }

}
