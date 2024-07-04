package daml.daml.finance.interface$.settlement.batch;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
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

  public final Id id;

  public final String description;

  public final Optional<Id> contextId;

  public final List<RoutedStep> routedSteps;

  public final Optional<Instant> settlementTime;

  public View(String instructor, Set<String> consenters, Set<String> settlers, Id id,
      String description, Optional<Id> contextId, List<RoutedStep> routedSteps,
      Optional<Instant> settlementTime) {
    this.instructor = instructor;
    this.consenters = consenters;
    this.settlers = settlers;
    this.id = id;
    this.description = description;
    this.contextId = contextId;
    this.routedSteps = routedSteps;
    this.settlementTime = settlementTime;
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
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(8,1,
          recordValue$);
      String instructor = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> consenters = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Set<String> settlers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(3).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      Optional<Id> contextId = PrimitiveValueDecoders.fromOptional(Id.valueDecoder())
          .decode(fields$.get(5).getValue());
      List<RoutedStep> routedSteps = PrimitiveValueDecoders.fromList(RoutedStep.valueDecoder())
          .decode(fields$.get(6).getValue());
      Optional<Instant> settlementTime = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromTimestamp).decode(fields$.get(7).getValue());
      return new View(instructor, consenters, settlers, id, description, contextId, routedSteps,
          settlementTime);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(8);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instructor", new Party(this.instructor)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("consenters", this.consenters.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("settlers", this.settlers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("contextId", DamlOptional.of(this.contextId.map(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("routedSteps", this.routedSteps.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("settlementTime", DamlOptional.of(this.settlementTime.map(v$0 -> Timestamp.fromInstant(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instructor", "consenters", "settlers", "id", "description", "contextId", "routedSteps", "settlementTime"), name -> {
          switch (name) {
            case "instructor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "consenters": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "settlers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "contextId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.daml.finance.interface$.types.common.types.Id.jsonDecoder()));
            case "routedSteps": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.settlement.types.RoutedStep.jsonDecoder()));
            case "settlementTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp));
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instructor", apply(JsonLfEncoders::party, instructor)),
        JsonLfEncoders.Field.of("consenters", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), consenters)),
        JsonLfEncoders.Field.of("settlers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), settlers)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("contextId", apply(JsonLfEncoders.optional(Id::jsonEncoder), contextId)),
        JsonLfEncoders.Field.of("routedSteps", apply(JsonLfEncoders.list(RoutedStep::jsonEncoder), routedSteps)),
        JsonLfEncoders.Field.of("settlementTime", apply(JsonLfEncoders.optional(JsonLfEncoders::timestamp), settlementTime)));
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
        Objects.equals(this.settlers, other.settlers) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.contextId, other.contextId) &&
        Objects.equals(this.routedSteps, other.routedSteps) &&
        Objects.equals(this.settlementTime, other.settlementTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instructor, this.consenters, this.settlers, this.id, this.description,
        this.contextId, this.routedSteps, this.settlementTime);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.settlement.batch.View(%s, %s, %s, %s, %s, %s, %s, %s)",
        this.instructor, this.consenters, this.settlers, this.id, this.description, this.contextId,
        this.routedSteps, this.settlementTime);
  }
}
