package daml.interface$.propertymanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
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
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.interface$.propertymanager.property.common.GarageType;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RequestCreateGarageProperty extends DamlRecord<RequestCreateGarageProperty> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final Id id;

  public final InstrumentKey garageInstrument;

  public final BigDecimal garagePrice;

  public final String propertyAddress;

  public final String propertyPostalCode;

  public final String propertyDistrict;

  public final String propertyCounty;

  public final BigDecimal garageArea;

  public final GarageType garageType;

  public final Long vehicleCapacity;

  public final String installedEquipment;

  public final String additionalInformation;

  public final String description;

  public final List<String> photoReferences;

  public final Map<String, Set<String>> observers;

  public RequestCreateGarageProperty(Id id, InstrumentKey garageInstrument, BigDecimal garagePrice,
      String propertyAddress, String propertyPostalCode, String propertyDistrict,
      String propertyCounty, BigDecimal garageArea, GarageType garageType, Long vehicleCapacity,
      String installedEquipment, String additionalInformation, String description,
      List<String> photoReferences, Map<String, Set<String>> observers) {
    this.id = id;
    this.garageInstrument = garageInstrument;
    this.garagePrice = garagePrice;
    this.propertyAddress = propertyAddress;
    this.propertyPostalCode = propertyPostalCode;
    this.propertyDistrict = propertyDistrict;
    this.propertyCounty = propertyCounty;
    this.garageArea = garageArea;
    this.garageType = garageType;
    this.vehicleCapacity = vehicleCapacity;
    this.installedEquipment = installedEquipment;
    this.additionalInformation = additionalInformation;
    this.description = description;
    this.photoReferences = photoReferences;
    this.observers = observers;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RequestCreateGarageProperty fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RequestCreateGarageProperty> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(15,0,
          recordValue$);
      Id id = Id.valueDecoder().decode(fields$.get(0).getValue());
      InstrumentKey garageInstrument = InstrumentKey.valueDecoder()
          .decode(fields$.get(1).getValue());
      BigDecimal garagePrice = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(2).getValue());
      String propertyAddress = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      String propertyPostalCode = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      String propertyDistrict = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      String propertyCounty = PrimitiveValueDecoders.fromText.decode(fields$.get(6).getValue());
      BigDecimal garageArea = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(7).getValue());
      GarageType garageType = GarageType.valueDecoder().decode(fields$.get(8).getValue());
      Long vehicleCapacity = PrimitiveValueDecoders.fromInt64.decode(fields$.get(9).getValue());
      String installedEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(10).getValue());
      String additionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(11).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(12).getValue());
      List<String> photoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(13).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(14).getValue());
      return new RequestCreateGarageProperty(id, garageInstrument, garagePrice, propertyAddress,
          propertyPostalCode, propertyDistrict, propertyCounty, garageArea, garageType,
          vehicleCapacity, installedEquipment, additionalInformation, description, photoReferences,
          observers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(15);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("garageInstrument", this.garageInstrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("garagePrice", new Numeric(this.garagePrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyAddress", new Text(this.propertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyPostalCode", new Text(this.propertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyDistrict", new Text(this.propertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyCounty", new Text(this.propertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("garageArea", new Numeric(this.garageArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("garageType", this.garageType.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("vehicleCapacity", new Int64(this.vehicleCapacity)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("installedEquipment", new Text(this.installedEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("additionalInformation", new Text(this.additionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("photoReferences", this.photoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RequestCreateGarageProperty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("id", "garageInstrument", "garagePrice", "propertyAddress", "propertyPostalCode", "propertyDistrict", "propertyCounty", "garageArea", "garageType", "vehicleCapacity", "installedEquipment", "additionalInformation", "description", "photoReferences", "observers"), name -> {
          switch (name) {
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "garageInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "garagePrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "propertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "garageArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "garageType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, daml.interface$.propertymanager.property.common.GarageType.jsonDecoder());
            case "vehicleCapacity": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "installedEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "additionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "photoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new RequestCreateGarageProperty(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14])));
  }

  public static RequestCreateGarageProperty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("garageInstrument", apply(InstrumentKey::jsonEncoder, garageInstrument)),
        JsonLfEncoders.Field.of("garagePrice", apply(JsonLfEncoders::numeric, garagePrice)),
        JsonLfEncoders.Field.of("propertyAddress", apply(JsonLfEncoders::text, propertyAddress)),
        JsonLfEncoders.Field.of("propertyPostalCode", apply(JsonLfEncoders::text, propertyPostalCode)),
        JsonLfEncoders.Field.of("propertyDistrict", apply(JsonLfEncoders::text, propertyDistrict)),
        JsonLfEncoders.Field.of("propertyCounty", apply(JsonLfEncoders::text, propertyCounty)),
        JsonLfEncoders.Field.of("garageArea", apply(JsonLfEncoders::numeric, garageArea)),
        JsonLfEncoders.Field.of("garageType", apply(GarageType::jsonEncoder, garageType)),
        JsonLfEncoders.Field.of("vehicleCapacity", apply(JsonLfEncoders::int64, vehicleCapacity)),
        JsonLfEncoders.Field.of("installedEquipment", apply(JsonLfEncoders::text, installedEquipment)),
        JsonLfEncoders.Field.of("additionalInformation", apply(JsonLfEncoders::text, additionalInformation)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("photoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), photoReferences)),
        JsonLfEncoders.Field.of("observers", apply(JsonLfEncoders.genMap(JsonLfEncoders::text, _x1 -> _x1.jsonEncoder(JsonLfEncoders::party)), observers)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof RequestCreateGarageProperty)) {
      return false;
    }
    RequestCreateGarageProperty other = (RequestCreateGarageProperty) object;
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.garageInstrument, other.garageInstrument) &&
        Objects.equals(this.garagePrice, other.garagePrice) &&
        Objects.equals(this.propertyAddress, other.propertyAddress) &&
        Objects.equals(this.propertyPostalCode, other.propertyPostalCode) &&
        Objects.equals(this.propertyDistrict, other.propertyDistrict) &&
        Objects.equals(this.propertyCounty, other.propertyCounty) &&
        Objects.equals(this.garageArea, other.garageArea) &&
        Objects.equals(this.garageType, other.garageType) &&
        Objects.equals(this.vehicleCapacity, other.vehicleCapacity) &&
        Objects.equals(this.installedEquipment, other.installedEquipment) &&
        Objects.equals(this.additionalInformation, other.additionalInformation) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.photoReferences, other.photoReferences) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.garageInstrument, this.garagePrice, this.propertyAddress,
        this.propertyPostalCode, this.propertyDistrict, this.propertyCounty, this.garageArea,
        this.garageType, this.vehicleCapacity, this.installedEquipment, this.additionalInformation,
        this.description, this.photoReferences, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.RequestCreateGarageProperty(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.id, this.garageInstrument, this.garagePrice, this.propertyAddress,
        this.propertyPostalCode, this.propertyDistrict, this.propertyCounty, this.garageArea,
        this.garageType, this.vehicleCapacity, this.installedEquipment, this.additionalInformation,
        this.description, this.photoReferences, this.observers);
  }
}
