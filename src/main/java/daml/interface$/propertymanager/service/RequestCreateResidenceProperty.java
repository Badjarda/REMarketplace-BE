package daml.interface$.propertymanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Date;
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
import daml.interface$.propertymanager.property.common.Orientation;
import daml.interface$.propertymanager.property.common.Parking;
import daml.interface$.propertymanager.property.common.ResidenceType;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RequestCreateResidenceProperty extends DamlRecord<RequestCreateResidenceProperty> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final Id id;

  public final InstrumentKey residenceInstrument;

  public final BigDecimal residencePrice;

  public final String propertyAddress;

  public final String propertyPostalCode;

  public final String propertyDistrict;

  public final String propertyCounty;

  public final BigDecimal grossArea;

  public final BigDecimal usableArea;

  public final Long bedrooms;

  public final Long bathrooms;

  public final Long floors;

  public final ResidenceType residenceType;

  public final String backyard;

  public final Parking parking;

  public final LocalDate buildDate;

  public final Orientation orientation;

  public final String installedEquipment;

  public final String additionalInformation;

  public final String description;

  public final List<String> photoReferences;

  public final Map<String, Set<String>> observers;

  public RequestCreateResidenceProperty(Id id, InstrumentKey residenceInstrument,
      BigDecimal residencePrice, String propertyAddress, String propertyPostalCode,
      String propertyDistrict, String propertyCounty, BigDecimal grossArea, BigDecimal usableArea,
      Long bedrooms, Long bathrooms, Long floors, ResidenceType residenceType, String backyard,
      Parking parking, LocalDate buildDate, Orientation orientation, String installedEquipment,
      String additionalInformation, String description, List<String> photoReferences,
      Map<String, Set<String>> observers) {
    this.id = id;
    this.residenceInstrument = residenceInstrument;
    this.residencePrice = residencePrice;
    this.propertyAddress = propertyAddress;
    this.propertyPostalCode = propertyPostalCode;
    this.propertyDistrict = propertyDistrict;
    this.propertyCounty = propertyCounty;
    this.grossArea = grossArea;
    this.usableArea = usableArea;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.floors = floors;
    this.residenceType = residenceType;
    this.backyard = backyard;
    this.parking = parking;
    this.buildDate = buildDate;
    this.orientation = orientation;
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
  public static RequestCreateResidenceProperty fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RequestCreateResidenceProperty> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(22,0,
          recordValue$);
      Id id = Id.valueDecoder().decode(fields$.get(0).getValue());
      InstrumentKey residenceInstrument = InstrumentKey.valueDecoder()
          .decode(fields$.get(1).getValue());
      BigDecimal residencePrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(2).getValue());
      String propertyAddress = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      String propertyPostalCode = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      String propertyDistrict = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      String propertyCounty = PrimitiveValueDecoders.fromText.decode(fields$.get(6).getValue());
      BigDecimal grossArea = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(7).getValue());
      BigDecimal usableArea = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(8).getValue());
      Long bedrooms = PrimitiveValueDecoders.fromInt64.decode(fields$.get(9).getValue());
      Long bathrooms = PrimitiveValueDecoders.fromInt64.decode(fields$.get(10).getValue());
      Long floors = PrimitiveValueDecoders.fromInt64.decode(fields$.get(11).getValue());
      ResidenceType residenceType = ResidenceType.valueDecoder().decode(fields$.get(12).getValue());
      String backyard = PrimitiveValueDecoders.fromText.decode(fields$.get(13).getValue());
      Parking parking = Parking.valueDecoder().decode(fields$.get(14).getValue());
      LocalDate buildDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(15).getValue());
      Orientation orientation = Orientation.valueDecoder().decode(fields$.get(16).getValue());
      String installedEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(17).getValue());
      String additionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(18).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(19).getValue());
      List<String> photoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(20).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(21).getValue());
      return new RequestCreateResidenceProperty(id, residenceInstrument, residencePrice,
          propertyAddress, propertyPostalCode, propertyDistrict, propertyCounty, grossArea,
          usableArea, bedrooms, bathrooms, floors, residenceType, backyard, parking, buildDate,
          orientation, installedEquipment, additionalInformation, description, photoReferences,
          observers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(22);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("residenceInstrument", this.residenceInstrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("residencePrice", new Numeric(this.residencePrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyAddress", new Text(this.propertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyPostalCode", new Text(this.propertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyDistrict", new Text(this.propertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyCounty", new Text(this.propertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("grossArea", new Numeric(this.grossArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("usableArea", new Numeric(this.usableArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("bedrooms", new Int64(this.bedrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("bathrooms", new Int64(this.bathrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("floors", new Int64(this.floors)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("residenceType", this.residenceType.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("backyard", new Text(this.backyard)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("parking", this.parking.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buildDate", new Date((int) this.buildDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("orientation", this.orientation.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("installedEquipment", new Text(this.installedEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("additionalInformation", new Text(this.additionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("photoReferences", this.photoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RequestCreateResidenceProperty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("id", "residenceInstrument", "residencePrice", "propertyAddress", "propertyPostalCode", "propertyDistrict", "propertyCounty", "grossArea", "usableArea", "bedrooms", "bathrooms", "floors", "residenceType", "backyard", "parking", "buildDate", "orientation", "installedEquipment", "additionalInformation", "description", "photoReferences", "observers"), name -> {
          switch (name) {
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "residenceInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "residencePrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "propertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "grossArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "usableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "bedrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "bathrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "floors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "residenceType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, daml.interface$.propertymanager.property.common.ResidenceType.jsonDecoder());
            case "backyard": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "parking": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, daml.interface$.propertymanager.property.common.Parking.jsonDecoder());
            case "buildDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "orientation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, daml.interface$.propertymanager.property.common.Orientation.jsonDecoder());
            case "installedEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(17, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "additionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(18, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(19, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "photoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(20, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(21, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new RequestCreateResidenceProperty(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16]), JsonLfDecoders.cast(args[17]), JsonLfDecoders.cast(args[18]), JsonLfDecoders.cast(args[19]), JsonLfDecoders.cast(args[20]), JsonLfDecoders.cast(args[21])));
  }

  public static RequestCreateResidenceProperty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("residenceInstrument", apply(InstrumentKey::jsonEncoder, residenceInstrument)),
        JsonLfEncoders.Field.of("residencePrice", apply(JsonLfEncoders::numeric, residencePrice)),
        JsonLfEncoders.Field.of("propertyAddress", apply(JsonLfEncoders::text, propertyAddress)),
        JsonLfEncoders.Field.of("propertyPostalCode", apply(JsonLfEncoders::text, propertyPostalCode)),
        JsonLfEncoders.Field.of("propertyDistrict", apply(JsonLfEncoders::text, propertyDistrict)),
        JsonLfEncoders.Field.of("propertyCounty", apply(JsonLfEncoders::text, propertyCounty)),
        JsonLfEncoders.Field.of("grossArea", apply(JsonLfEncoders::numeric, grossArea)),
        JsonLfEncoders.Field.of("usableArea", apply(JsonLfEncoders::numeric, usableArea)),
        JsonLfEncoders.Field.of("bedrooms", apply(JsonLfEncoders::int64, bedrooms)),
        JsonLfEncoders.Field.of("bathrooms", apply(JsonLfEncoders::int64, bathrooms)),
        JsonLfEncoders.Field.of("floors", apply(JsonLfEncoders::int64, floors)),
        JsonLfEncoders.Field.of("residenceType", apply(ResidenceType::jsonEncoder, residenceType)),
        JsonLfEncoders.Field.of("backyard", apply(JsonLfEncoders::text, backyard)),
        JsonLfEncoders.Field.of("parking", apply(Parking::jsonEncoder, parking)),
        JsonLfEncoders.Field.of("buildDate", apply(JsonLfEncoders::date, buildDate)),
        JsonLfEncoders.Field.of("orientation", apply(Orientation::jsonEncoder, orientation)),
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
    if (!(object instanceof RequestCreateResidenceProperty)) {
      return false;
    }
    RequestCreateResidenceProperty other = (RequestCreateResidenceProperty) object;
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.residenceInstrument, other.residenceInstrument) &&
        Objects.equals(this.residencePrice, other.residencePrice) &&
        Objects.equals(this.propertyAddress, other.propertyAddress) &&
        Objects.equals(this.propertyPostalCode, other.propertyPostalCode) &&
        Objects.equals(this.propertyDistrict, other.propertyDistrict) &&
        Objects.equals(this.propertyCounty, other.propertyCounty) &&
        Objects.equals(this.grossArea, other.grossArea) &&
        Objects.equals(this.usableArea, other.usableArea) &&
        Objects.equals(this.bedrooms, other.bedrooms) &&
        Objects.equals(this.bathrooms, other.bathrooms) &&
        Objects.equals(this.floors, other.floors) &&
        Objects.equals(this.residenceType, other.residenceType) &&
        Objects.equals(this.backyard, other.backyard) &&
        Objects.equals(this.parking, other.parking) &&
        Objects.equals(this.buildDate, other.buildDate) &&
        Objects.equals(this.orientation, other.orientation) &&
        Objects.equals(this.installedEquipment, other.installedEquipment) &&
        Objects.equals(this.additionalInformation, other.additionalInformation) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.photoReferences, other.photoReferences) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.residenceInstrument, this.residencePrice,
        this.propertyAddress, this.propertyPostalCode, this.propertyDistrict, this.propertyCounty,
        this.grossArea, this.usableArea, this.bedrooms, this.bathrooms, this.floors,
        this.residenceType, this.backyard, this.parking, this.buildDate, this.orientation,
        this.installedEquipment, this.additionalInformation, this.description, this.photoReferences,
        this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.RequestCreateResidenceProperty(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.id, this.residenceInstrument, this.residencePrice, this.propertyAddress,
        this.propertyPostalCode, this.propertyDistrict, this.propertyCounty, this.grossArea,
        this.usableArea, this.bedrooms, this.bathrooms, this.floors, this.residenceType,
        this.backyard, this.parking, this.buildDate, this.orientation, this.installedEquipment,
        this.additionalInformation, this.description, this.photoReferences, this.observers);
  }
}
