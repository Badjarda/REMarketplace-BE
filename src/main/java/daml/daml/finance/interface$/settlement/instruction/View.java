package daml.daml.finance.interface$.settlement.instruction;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Timestamp;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.settlement.types.Allocation;
import daml.daml.finance.interface$.settlement.types.Approval;
import daml.daml.finance.interface$.settlement.types.RoutedStep;
import daml.daml.finance.interface$.types.common.types.Id;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class View extends DamlRecord<View> {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final String instructor;

  public final Set<String> consenters;

  public final Set<String> settlers;

  public final Id batchId;

  public final Id id;

  public final RoutedStep routedStep;

  public final Optional<Instant> settlementTime;

  public final Allocation allocation;

  public final Approval approval;

  public final Set<String> signedSenders;

  public final Set<String> signedReceivers;

  public View(String instructor, Set<String> consenters, Set<String> settlers, Id batchId, Id id,
      RoutedStep routedStep, Optional<Instant> settlementTime, Allocation allocation,
      Approval approval, Set<String> signedSenders, Set<String> signedReceivers) {
    this.instructor = instructor;
    this.consenters = consenters;
    this.settlers = settlers;
    this.batchId = batchId;
    this.id = id;
    this.routedStep = routedStep;
    this.settlementTime = settlementTime;
    this.allocation = allocation;
    this.approval = approval;
    this.signedSenders = signedSenders;
    this.signedReceivers = signedReceivers;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static View fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<View> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(11,0,
          recordValue$);
      String instructor = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> consenters = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Set<String> settlers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      Id batchId = Id.valueDecoder().decode(fields$.get(3).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(4).getValue());
      RoutedStep routedStep = RoutedStep.valueDecoder().decode(fields$.get(5).getValue());
      Optional<Instant> settlementTime = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromTimestamp).decode(fields$.get(6).getValue());
      Allocation allocation = Allocation.valueDecoder().decode(fields$.get(7).getValue());
      Approval approval = Approval.valueDecoder().decode(fields$.get(8).getValue());
      Set<String> signedSenders =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(9).getValue());
      Set<String> signedReceivers =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(10).getValue());
      return new View(instructor, consenters, settlers, batchId, id, routedStep, settlementTime,
          allocation, approval, signedSenders, signedReceivers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(11);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instructor", new Party(this.instructor)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("consenters", this.consenters.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("settlers", this.settlers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("batchId", this.batchId.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("routedStep", this.routedStep.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("settlementTime", DamlOptional.of(this.settlementTime.map(v$0 -> Timestamp.fromInstant(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("allocation", this.allocation.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("approval", this.approval.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("signedSenders", this.signedSenders.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("signedReceivers", this.signedReceivers.toValue(v$0 -> new Party(v$0))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instructor", "consenters", "settlers", "batchId", "id", "routedStep", "settlementTime", "allocation", "approval", "signedSenders", "signedReceivers"), name -> {
          switch (name) {
            case "instructor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "consenters": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "settlers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "batchId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "routedStep": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.daml.finance.interface$.settlement.types.RoutedStep.jsonDecoder());
            case "settlementTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp));
            case "allocation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, daml.daml.finance.interface$.settlement.types.Allocation.jsonDecoder());
            case "approval": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, daml.daml.finance.interface$.settlement.types.Approval.jsonDecoder());
            case "signedSenders": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "signedReceivers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instructor", apply(JsonLfEncoders::party, instructor)),
        JsonLfEncoders.Field.of("consenters", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), consenters)),
        JsonLfEncoders.Field.of("settlers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), settlers)),
        JsonLfEncoders.Field.of("batchId", apply(Id::jsonEncoder, batchId)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("routedStep", apply(RoutedStep::jsonEncoder, routedStep)),
        JsonLfEncoders.Field.of("settlementTime", apply(JsonLfEncoders.optional(JsonLfEncoders::timestamp), settlementTime)),
        JsonLfEncoders.Field.of("allocation", apply(Allocation::jsonEncoder, allocation)),
        JsonLfEncoders.Field.of("approval", apply(Approval::jsonEncoder, approval)),
        JsonLfEncoders.Field.of("signedSenders", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), signedSenders)),
        JsonLfEncoders.Field.of("signedReceivers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), signedReceivers)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof View)) {
      return false;
    }
    View other = (View) object;
    return Objects.equals(this.instructor, other.instructor) &&
        Objects.equals(this.consenters, other.consenters) &&
        Objects.equals(this.settlers, other.settlers) &&
        Objects.equals(this.batchId, other.batchId) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.routedStep, other.routedStep) &&
        Objects.equals(this.settlementTime, other.settlementTime) &&
        Objects.equals(this.allocation, other.allocation) &&
        Objects.equals(this.approval, other.approval) &&
        Objects.equals(this.signedSenders, other.signedSenders) &&
        Objects.equals(this.signedReceivers, other.signedReceivers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instructor, this.consenters, this.settlers, this.batchId, this.id,
        this.routedStep, this.settlementTime, this.allocation, this.approval, this.signedSenders,
        this.signedReceivers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.settlement.instruction.View(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.instructor, this.consenters, this.settlers, this.batchId, this.id, this.routedStep,
        this.settlementTime, this.allocation, this.approval, this.signedSenders,
        this.signedReceivers);
  }
}
