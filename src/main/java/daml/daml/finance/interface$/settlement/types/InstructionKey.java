package daml.daml.finance.interface$.settlement.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.daml.finance.interface$.types.common.types.Id;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InstructionKey extends DamlRecord<InstructionKey> {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final String instructor;

  public final Id batchId;

  public final Id id;

  public InstructionKey(String instructor, Id batchId, Id id) {
    this.instructor = instructor;
    this.batchId = batchId;
    this.id = id;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static InstructionKey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<InstructionKey> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String instructor = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Id batchId = Id.valueDecoder().decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      return new InstructionKey(instructor, batchId, id);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instructor", new Party(this.instructor)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("batchId", this.batchId.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<InstructionKey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instructor", "batchId", "id"), name -> {
          switch (name) {
            case "instructor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "batchId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new InstructionKey(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static InstructionKey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instructor", apply(JsonLfEncoders::party, instructor)),
        JsonLfEncoders.Field.of("batchId", apply(Id::jsonEncoder, batchId)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof InstructionKey)) {
      return false;
    }
    InstructionKey other = (InstructionKey) object;
    return Objects.equals(this.instructor, other.instructor) &&
        Objects.equals(this.batchId, other.batchId) && Objects.equals(this.id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instructor, this.batchId, this.id);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.settlement.types.InstructionKey(%s, %s, %s)",
        this.instructor, this.batchId, this.id);
  }
}
