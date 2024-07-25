package daml.interface$.propertymanager.property.residenceproperty.residenceproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Date;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetResidenceBuildDate extends DamlRecord<SetResidenceBuildDate> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final LocalDate newResidenceBuildDate;

  public SetResidenceBuildDate(LocalDate newResidenceBuildDate) {
    this.newResidenceBuildDate = newResidenceBuildDate;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetResidenceBuildDate fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetResidenceBuildDate> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      LocalDate newResidenceBuildDate = PrimitiveValueDecoders.fromDate
          .decode(fields$.get(0).getValue());
      return new SetResidenceBuildDate(newResidenceBuildDate);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceBuildDate", new Date((int) this.newResidenceBuildDate.toEpochDay())));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetResidenceBuildDate> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newResidenceBuildDate"), name -> {
          switch (name) {
            case "newResidenceBuildDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            default: return null;
          }
        }
        , (Object[] args) -> new SetResidenceBuildDate(JsonLfDecoders.cast(args[0])));
  }

  public static SetResidenceBuildDate fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newResidenceBuildDate", apply(JsonLfEncoders::date, newResidenceBuildDate)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetResidenceBuildDate)) {
      return false;
    }
    SetResidenceBuildDate other = (SetResidenceBuildDate) object;
    return Objects.equals(this.newResidenceBuildDate, other.newResidenceBuildDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newResidenceBuildDate);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.residenceproperty.residenceproperty.SetResidenceBuildDate(%s)",
        this.newResidenceBuildDate);
  }
}
