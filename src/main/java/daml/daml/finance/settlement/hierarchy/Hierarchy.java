package daml.daml.finance.settlement.hierarchy;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
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
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Hierarchy extends DamlRecord<Hierarchy> {
  public static final String _packageId = "ea5a2fa6a1df87c3279c4672835e49813545489febd9d5f9e076ca36db837b33";

  public final String rootCustodian;

  public final List<List<String>> pathsToRootCustodian;

  public Hierarchy(String rootCustodian, List<List<String>> pathsToRootCustodian) {
    this.rootCustodian = rootCustodian;
    this.pathsToRootCustodian = pathsToRootCustodian;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Hierarchy fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Hierarchy> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String rootCustodian = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      List<List<String>> pathsToRootCustodian = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(1).getValue());
      return new Hierarchy(rootCustodian, pathsToRootCustodian);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("rootCustodian", new Party(this.rootCustodian)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("pathsToRootCustodian", this.pathsToRootCustodian.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.stream().collect(DamlCollectors.toDamlList(v$1 -> new Party(v$1)))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Hierarchy> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("rootCustodian", "pathsToRootCustodian"), name -> {
          switch (name) {
            case "rootCustodian": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "pathsToRootCustodian": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Hierarchy(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Hierarchy fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("rootCustodian", apply(JsonLfEncoders::party, rootCustodian)),
        JsonLfEncoders.Field.of("pathsToRootCustodian", apply(JsonLfEncoders.list(JsonLfEncoders.list(JsonLfEncoders::party)), pathsToRootCustodian)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Hierarchy)) {
      return false;
    }
    Hierarchy other = (Hierarchy) object;
    return Objects.equals(this.rootCustodian, other.rootCustodian) &&
        Objects.equals(this.pathsToRootCustodian, other.pathsToRootCustodian);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.rootCustodian, this.pathsToRootCustodian);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.settlement.hierarchy.Hierarchy(%s, %s)",
        this.rootCustodian, this.pathsToRootCustodian);
  }
}
