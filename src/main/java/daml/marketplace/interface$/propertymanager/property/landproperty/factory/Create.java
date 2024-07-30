package daml.interface$.propertymanager.property.landproperty.factory;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
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
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.interface$.common.types.PropertyKey;
import daml.interface$.propertymanager.property.common.LandType;
import daml.interface$.propertymanager.property.common.ViableConstructionTypes;
import java.lang.Boolean;
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

public class Create extends DamlRecord<Create> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final InstrumentKey instrument;

  public final BigDecimal landPrice;

  public final PropertyKey propertyKey;

  public final String propertyAddress;

  public final String propertyPostalCode;

  public final String propertyDistrict;

  public final String propertyCounty;

  public final LandType landType;

  public final BigDecimal totalLandArea;

  public final BigDecimal minimumSurfaceForSale;

  public final BigDecimal buildableArea;

  public final Long buildableFloors;

  public final Boolean accessByRoad;

  public final String installedEquipment;

  public final List<ViableConstructionTypes> viableConstructionTypes;

  public final String additionalInformation;

  public final String description;

  public final List<String> photoReferences;

  public final Map<String, Set<String>> observers;

  public Create(InstrumentKey instrument, BigDecimal landPrice, PropertyKey propertyKey,
      String propertyAddress, String propertyPostalCode, String propertyDistrict,
      String propertyCounty, LandType landType, BigDecimal totalLandArea,
      BigDecimal minimumSurfaceForSale, BigDecimal buildableArea, Long buildableFloors,
      Boolean accessByRoad, String installedEquipment,
      List<ViableConstructionTypes> viableConstructionTypes, String additionalInformation,
      String description, List<String> photoReferences, Map<String, Set<String>> observers) {
    this.instrument = instrument;
    this.landPrice = landPrice;
    this.propertyKey = propertyKey;
    this.propertyAddress = propertyAddress;
    this.propertyPostalCode = propertyPostalCode;
    this.propertyDistrict = propertyDistrict;
    this.propertyCounty = propertyCounty;
    this.landType = landType;
    this.totalLandArea = totalLandArea;
    this.minimumSurfaceForSale = minimumSurfaceForSale;
    this.buildableArea = buildableArea;
    this.buildableFloors = buildableFloors;
    this.accessByRoad = accessByRoad;
    this.installedEquipment = installedEquipment;
    this.viableConstructionTypes = viableConstructionTypes;
    this.additionalInformation = additionalInformation;
    this.description = description;
    this.photoReferences = photoReferences;
    this.observers = observers;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Create fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Create> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(19,0,
          recordValue$);
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(0).getValue());
      BigDecimal landPrice = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(1).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(2).getValue());
      String propertyAddress = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      String propertyPostalCode = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      String propertyDistrict = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      String propertyCounty = PrimitiveValueDecoders.fromText.decode(fields$.get(6).getValue());
      LandType landType = LandType.valueDecoder().decode(fields$.get(7).getValue());
      BigDecimal totalLandArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(8).getValue());
      BigDecimal minimumSurfaceForSale = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(9).getValue());
      BigDecimal buildableArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(10).getValue());
      Long buildableFloors = PrimitiveValueDecoders.fromInt64.decode(fields$.get(11).getValue());
      Boolean accessByRoad = PrimitiveValueDecoders.fromBool.decode(fields$.get(12).getValue());
      String installedEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(13).getValue());
      List<ViableConstructionTypes> viableConstructionTypes = PrimitiveValueDecoders.fromList(
            ViableConstructionTypes.valueDecoder()).decode(fields$.get(14).getValue());
      String additionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(15).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(16).getValue());
      List<String> photoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(17).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(18).getValue());
      return new Create(instrument, landPrice, propertyKey, propertyAddress, propertyPostalCode,
          propertyDistrict, propertyCounty, landType, totalLandArea, minimumSurfaceForSale,
          buildableArea, buildableFloors, accessByRoad, installedEquipment, viableConstructionTypes,
          additionalInformation, description, photoReferences, observers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(19);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instrument", this.instrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("landPrice", new Numeric(this.landPrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyAddress", new Text(this.propertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyPostalCode", new Text(this.propertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyDistrict", new Text(this.propertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyCounty", new Text(this.propertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("landType", this.landType.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("totalLandArea", new Numeric(this.totalLandArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("minimumSurfaceForSale", new Numeric(this.minimumSurfaceForSale)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buildableArea", new Numeric(this.buildableArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buildableFloors", new Int64(this.buildableFloors)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("accessByRoad", Bool.of(this.accessByRoad)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("installedEquipment", new Text(this.installedEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("viableConstructionTypes", this.viableConstructionTypes.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("additionalInformation", new Text(this.additionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("photoReferences", this.photoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Create> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instrument", "landPrice", "propertyKey", "propertyAddress", "propertyPostalCode", "propertyDistrict", "propertyCounty", "landType", "totalLandArea", "minimumSurfaceForSale", "buildableArea", "buildableFloors", "accessByRoad", "installedEquipment", "viableConstructionTypes", "additionalInformation", "description", "photoReferences", "observers"), name -> {
          switch (name) {
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "landPrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.interface$.common.types.PropertyKey.jsonDecoder());
            case "propertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "landType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, daml.interface$.propertymanager.property.common.LandType.jsonDecoder());
            case "totalLandArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "minimumSurfaceForSale": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "buildableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "buildableFloors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "accessByRoad": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            case "installedEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "viableConstructionTypes": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.interface$.propertymanager.property.common.ViableConstructionTypes.jsonDecoder()));
            case "additionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "photoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(17, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(18, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Create(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16]), JsonLfDecoders.cast(args[17]), JsonLfDecoders.cast(args[18])));
  }

  public static Create fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)),
        JsonLfEncoders.Field.of("landPrice", apply(JsonLfEncoders::numeric, landPrice)),
        JsonLfEncoders.Field.of("propertyKey", apply(PropertyKey::jsonEncoder, propertyKey)),
        JsonLfEncoders.Field.of("propertyAddress", apply(JsonLfEncoders::text, propertyAddress)),
        JsonLfEncoders.Field.of("propertyPostalCode", apply(JsonLfEncoders::text, propertyPostalCode)),
        JsonLfEncoders.Field.of("propertyDistrict", apply(JsonLfEncoders::text, propertyDistrict)),
        JsonLfEncoders.Field.of("propertyCounty", apply(JsonLfEncoders::text, propertyCounty)),
        JsonLfEncoders.Field.of("landType", apply(LandType::jsonEncoder, landType)),
        JsonLfEncoders.Field.of("totalLandArea", apply(JsonLfEncoders::numeric, totalLandArea)),
        JsonLfEncoders.Field.of("minimumSurfaceForSale", apply(JsonLfEncoders::numeric, minimumSurfaceForSale)),
        JsonLfEncoders.Field.of("buildableArea", apply(JsonLfEncoders::numeric, buildableArea)),
        JsonLfEncoders.Field.of("buildableFloors", apply(JsonLfEncoders::int64, buildableFloors)),
        JsonLfEncoders.Field.of("accessByRoad", apply(JsonLfEncoders::bool, accessByRoad)),
        JsonLfEncoders.Field.of("installedEquipment", apply(JsonLfEncoders::text, installedEquipment)),
        JsonLfEncoders.Field.of("viableConstructionTypes", apply(JsonLfEncoders.list(ViableConstructionTypes::jsonEncoder), viableConstructionTypes)),
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
    if (!(object instanceof Create)) {
      return false;
    }
    Create other = (Create) object;
    return Objects.equals(this.instrument, other.instrument) &&
        Objects.equals(this.landPrice, other.landPrice) &&
        Objects.equals(this.propertyKey, other.propertyKey) &&
        Objects.equals(this.propertyAddress, other.propertyAddress) &&
        Objects.equals(this.propertyPostalCode, other.propertyPostalCode) &&
        Objects.equals(this.propertyDistrict, other.propertyDistrict) &&
        Objects.equals(this.propertyCounty, other.propertyCounty) &&
        Objects.equals(this.landType, other.landType) &&
        Objects.equals(this.totalLandArea, other.totalLandArea) &&
        Objects.equals(this.minimumSurfaceForSale, other.minimumSurfaceForSale) &&
        Objects.equals(this.buildableArea, other.buildableArea) &&
        Objects.equals(this.buildableFloors, other.buildableFloors) &&
        Objects.equals(this.accessByRoad, other.accessByRoad) &&
        Objects.equals(this.installedEquipment, other.installedEquipment) &&
        Objects.equals(this.viableConstructionTypes, other.viableConstructionTypes) &&
        Objects.equals(this.additionalInformation, other.additionalInformation) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.photoReferences, other.photoReferences) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instrument, this.landPrice, this.propertyKey, this.propertyAddress,
        this.propertyPostalCode, this.propertyDistrict, this.propertyCounty, this.landType,
        this.totalLandArea, this.minimumSurfaceForSale, this.buildableArea, this.buildableFloors,
        this.accessByRoad, this.installedEquipment, this.viableConstructionTypes,
        this.additionalInformation, this.description, this.photoReferences, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.landproperty.factory.Create(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.instrument, this.landPrice, this.propertyKey, this.propertyAddress,
        this.propertyPostalCode, this.propertyDistrict, this.propertyCounty, this.landType,
        this.totalLandArea, this.minimumSurfaceForSale, this.buildableArea, this.buildableFloors,
        this.accessByRoad, this.installedEquipment, this.viableConstructionTypes,
        this.additionalInformation, this.description, this.photoReferences, this.observers);
  }
}
