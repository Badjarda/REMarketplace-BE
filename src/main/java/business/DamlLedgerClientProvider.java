package business;

import com.daml.ledger.rxjava.DamlLedgerClient;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class DamlLedgerClientProvider implements AutoCloseable {
 
    
      
    private DamlLedgerClient client;

    public DamlLedgerClient getClient() {
        if (client == null) {
            // Create the DamlLedgerClient instance
            client = DamlLedgerClient.newBuilder("localhost", 6865).build();
            client.connect();            
        }
        
        return client;
    }
  
   
  
    @Override
    public void close() throws Exception {
      if (client != null) {
        try {
            client.close();
        } catch (Exception e) {
            // Handle exception
        }
    }
    }
}
