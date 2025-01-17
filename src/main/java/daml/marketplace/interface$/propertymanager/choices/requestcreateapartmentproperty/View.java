package daml.marketplace.interface$.propertymanager.choices.requestcreateapartmentproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
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
import java.lang.Boolean;
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

public class View extends DamlRecord<View> {
  public static final String _packageId = "b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9";

  public final String operator;

  public final String user;

  public final Id id;

  public final InstrumentKey apartmentInstrument;

  public final BigDecimal apartmentPrice;

  public final String propertyAddress;

  public final String propertyPostalCode;

  public final String propertyDistrict;

  public final String propertyCounty;

  public final BigDecimal grossArea;

  public final BigDecimal usableArea;

  public final Long bedrooms;

  public final Long bathrooms;

  public final Long floor;

  public final Long parkingSpaces;

  public final Boolean elevator;

  public final LocalDate buildDate;

  public final String installedEquipment;

  public final String additionalInformation;

  public final String description;

  public final List<String> photoReferences;

  public final Map<String, Set<String>> observers;

  public View(String operator, String user, Id id, InstrumentKey apartmentInstrument,
      BigDecimal apartmentPrice, String propertyAddress, String propertyPostalCode,
      String propertyDistrict, String propertyCounty, BigDecimal grossArea, BigDecimal usableArea,
      Long bedrooms, Long bathrooms, Long floor, Long parkingSpaces, Boolean elevator,
      LocalDate buildDate, String installedEquipment, String additionalInformation,
      String description, List<String> photoReferences, Map<String, Set<String>> observers) {
    this.operator = operator;
    this.user = user;
    this.id = id;
    this.apartmentInstrument = apartmentInstrument;
    this.apartmentPrice = apartmentPrice;
    this.propertyAddress = propertyAddress;
    this.propertyPostalCode = propertyPostalCode;
    this.propertyDistrict = propertyDistrict;
    this.propertyCounty = propertyCounty;
    this.grossArea = grossArea;
    this.usableArea = usableArea;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.floor = floor;
    this.parkingSpaces = parkingSpaces;
    this.elevator = elevator;
    this.buildDate = buildDate;
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
  public static View fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<View> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(22,0,
          recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      InstrumentKey apartmentInstrument = InstrumentKey.valueDecoder()
          .decode(fields$.get(3).getValue());
      BigDecimal apartmentPrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(4).getValue());
      String propertyAddress = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      String propertyPostalCode = PrimitiveValueDecoders.fromText.decode(fields$.get(6).getValue());
      String propertyDistrict = PrimitiveValueDecoders.fromText.decode(fields$.get(7).getValue());
      String propertyCounty = PrimitiveValueDecoders.fromText.decode(fields$.get(8).getValue());
      BigDecimal grossArea = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(9).getValue());
      BigDecimal usableArea = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(10).getValue());
      Long bedrooms = PrimitiveValueDecoders.fromInt64.decode(fields$.get(11).getValue());
      Long bathrooms = PrimitiveValueDecoders.fromInt64.decode(fields$.get(12).getValue());
      Long floor = PrimitiveValueDecoders.fromInt64.decode(fields$.get(13).getValue());
      Long parkingSpaces = PrimitiveValueDecoders.fromInt64.decode(fields$.get(14).getValue());
      Boolean elevator = PrimitiveValueDecoders.fromBool.decode(fields$.get(15).getValue());
      LocalDate buildDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(16).getValue());
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
      return new View(operator, user, id, apartmentInstrument, apartmentPrice, propertyAddress,
          propertyPostalCode, propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms,
          bathrooms, floor, parkingSpaces, elevator, buildDate, installedEquipment,
          additionalInformation, description, photoReferences, observers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(22);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("user", new Party(this.user)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("apartmentInstrument", this.apartmentInstrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("apartmentPrice", new Numeric(this.apartmentPrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyAddress", new Text(this.propertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyPostalCode", new Text(this.propertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyDistrict", new Text(this.propertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyCounty", new Text(this.propertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("grossArea", new Numeric(this.grossArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("usableArea", new Numeric(this.usableArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("bedrooms", new Int64(this.bedrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("bathrooms", new Int64(this.bathrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("floor", new Int64(this.floor)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("parkingSpaces", new Int64(this.parkingSpaces)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("elevator", Bool.of(this.elevator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buildDate", new Date((int) this.buildDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("installedEquipment", new Text(this.installedEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("additionalInformation", new Text(this.additionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("photoReferences", this.photoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "user", "id", "apartmentInstrument", "apartmentPrice", "propertyAddress", "propertyPostalCode", "propertyDistrict", "propertyCounty", "grossArea", "usableArea", "bedrooms", "bathrooms", "floor", "parkingSpaces", "elevator", "buildDate", "installedEquipment", "additionalInformation", "description", "photoReferences", "observers"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "apartmentInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "apartmentPrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "propertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "grossArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "usableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "bedrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "bathrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "floor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "parkingSpaces": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "elevator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            case "buildDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "installedEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(17, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "additionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(18, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(19, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "photoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(20, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(21, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16]), JsonLfDecoders.cast(args[17]), JsonLfDecoders.cast(args[18]), JsonLfDecoders.cast(args[19]), JsonLfDecoders.cast(args[20]), JsonLfDecoders.cast(args[21])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("apartmentInstrument", apply(InstrumentKey::jsonEncoder, apartmentInstrument)),
        JsonLfEncoders.Field.of("apartmentPrice", apply(JsonLfEncoders::numeric, apartmentPrice)),
        JsonLfEncoders.Field.of("propertyAddress", apply(JsonLfEncoders::text, propertyAddress)),
        JsonLfEncoders.Field.of("propertyPostalCode", apply(JsonLfEncoders::text, propertyPostalCode)),
        JsonLfEncoders.Field.of("propertyDistrict", apply(JsonLfEncoders::text, propertyDistrict)),
        JsonLfEncoders.Field.of("propertyCounty", apply(JsonLfEncoders::text, propertyCounty)),
        JsonLfEncoders.Field.of("grossArea", apply(JsonLfEncoders::numeric, grossArea)),
        JsonLfEncoders.Field.of("usableArea", apply(JsonLfEncoders::numeric, usableArea)),
        JsonLfEncoders.Field.of("bedrooms", apply(JsonLfEncoders::int64, bedrooms)),
        JsonLfEncoders.Field.of("bathrooms", apply(JsonLfEncoders::int64, bathrooms)),
        JsonLfEncoders.Field.of("floor", apply(JsonLfEncoders::int64, floor)),
        JsonLfEncoders.Field.of("parkingSpaces", apply(JsonLfEncoders::int64, parkingSpaces)),
        JsonLfEncoders.Field.of("elevator", apply(JsonLfEncoders::bool, elevator)),
        JsonLfEncoders.Field.of("buildDate", apply(JsonLfEncoders::date, buildDate)),
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
    if (!(object instanceof View)) {
      return false;
    }
    View other = (View) object;
    return Objects.equals(this.operator, other.operator) && Objects.equals(this.user, other.user) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.apartmentInstrument, other.apartmentInstrument) &&
        Objects.equals(this.apartmentPrice, other.apartmentPrice) &&
        Objects.equals(this.propertyAddress, other.propertyAddress) &&
        Objects.equals(this.propertyPostalCode, other.propertyPostalCode) &&
        Objects.equals(this.propertyDistrict, other.propertyDistrict) &&
        Objects.equals(this.propertyCounty, other.propertyCounty) &&
        Objects.equals(this.grossArea, other.grossArea) &&
        Objects.equals(this.usableArea, other.usableArea) &&
        Objects.equals(this.bedrooms, other.bedrooms) &&
        Objects.equals(this.bathrooms, other.bathrooms) &&
        Objects.equals(this.floor, other.floor) &&
        Objects.equals(this.parkingSpaces, other.parkingSpaces) &&
        Objects.equals(this.elevator, other.elevator) &&
        Objects.equals(this.buildDate, other.buildDate) &&
        Objects.equals(this.installedEquipment, other.installedEquipment) &&
        Objects.equals(this.additionalInformation, other.additionalInformation) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.photoReferences, other.photoReferences) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.user, this.id, this.apartmentInstrument,
        this.apartmentPrice, this.propertyAddress, this.propertyPostalCode, this.propertyDistrict,
        this.propertyCounty, this.grossArea, this.usableArea, this.bedrooms, this.bathrooms,
        this.floor, this.parkingSpaces, this.elevator, this.buildDate, this.installedEquipment,
        this.additionalInformation, this.description, this.photoReferences, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.choices.requestcreateapartmentproperty.View(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.user, this.id, this.apartmentInstrument, this.apartmentPrice,
        this.propertyAddress, this.propertyPostalCode, this.propertyDistrict, this.propertyCounty,
        this.grossArea, this.usableArea, this.bedrooms, this.bathrooms, this.floor,
        this.parkingSpaces, this.elevator, this.buildDate, this.installedEquipment,
        this.additionalInformation, this.description, this.photoReferences, this.observers);
  }
}
