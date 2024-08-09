package daml.interface$.propertymanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Numeric;
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
import java.util.Objects;

public class UpdateLand extends DamlRecord<UpdateLand> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final BigDecimal newLandPrice;

  public final String newLandPropertyAddress;

  public final String newLandPropertyPostalCode;

  public final String newLandPropertyDistrict;

  public final String newLandPropertyCounty;

  public final LandType newLandType;

  public final BigDecimal newLandTotalArea;

  public final BigDecimal newLandMinimumSurfaceForSale;

  public final BigDecimal newLandBuildableArea;

  public final Long newLandBuildableFloors;

  public final Boolean newLandAccessByRoad;

  public final String newLandInstalledEquipment;

  public final List<ViableConstructionTypes> newLandViableConstructionTypes;

  public final String newLandAdditionalInformation;

  public final String newLandDescription;

  public final List<String> newLandPhotoReferences;

  public final PropertyKey propertyKey;

  public UpdateLand(BigDecimal newLandPrice, String newLandPropertyAddress,
      String newLandPropertyPostalCode, String newLandPropertyDistrict,
      String newLandPropertyCounty, LandType newLandType, BigDecimal newLandTotalArea,
      BigDecimal newLandMinimumSurfaceForSale, BigDecimal newLandBuildableArea,
      Long newLandBuildableFloors, Boolean newLandAccessByRoad, String newLandInstalledEquipment,
      List<ViableConstructionTypes> newLandViableConstructionTypes,
      String newLandAdditionalInformation, String newLandDescription,
      List<String> newLandPhotoReferences, PropertyKey propertyKey) {
    this.newLandPrice = newLandPrice;
    this.newLandPropertyAddress = newLandPropertyAddress;
    this.newLandPropertyPostalCode = newLandPropertyPostalCode;
    this.newLandPropertyDistrict = newLandPropertyDistrict;
    this.newLandPropertyCounty = newLandPropertyCounty;
    this.newLandType = newLandType;
    this.newLandTotalArea = newLandTotalArea;
    this.newLandMinimumSurfaceForSale = newLandMinimumSurfaceForSale;
    this.newLandBuildableArea = newLandBuildableArea;
    this.newLandBuildableFloors = newLandBuildableFloors;
    this.newLandAccessByRoad = newLandAccessByRoad;
    this.newLandInstalledEquipment = newLandInstalledEquipment;
    this.newLandViableConstructionTypes = newLandViableConstructionTypes;
    this.newLandAdditionalInformation = newLandAdditionalInformation;
    this.newLandDescription = newLandDescription;
    this.newLandPhotoReferences = newLandPhotoReferences;
    this.propertyKey = propertyKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateLand fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateLand> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(17,0,
          recordValue$);
      BigDecimal newLandPrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      String newLandPropertyAddress = PrimitiveValueDecoders.fromText
          .decode(fields$.get(1).getValue());
      String newLandPropertyPostalCode = PrimitiveValueDecoders.fromText
          .decode(fields$.get(2).getValue());
      String newLandPropertyDistrict = PrimitiveValueDecoders.fromText
          .decode(fields$.get(3).getValue());
      String newLandPropertyCounty = PrimitiveValueDecoders.fromText
          .decode(fields$.get(4).getValue());
      LandType newLandType = LandType.valueDecoder().decode(fields$.get(5).getValue());
      BigDecimal newLandTotalArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(6).getValue());
      BigDecimal newLandMinimumSurfaceForSale = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(7).getValue());
      BigDecimal newLandBuildableArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(8).getValue());
      Long newLandBuildableFloors = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(9).getValue());
      Boolean newLandAccessByRoad = PrimitiveValueDecoders.fromBool
          .decode(fields$.get(10).getValue());
      String newLandInstalledEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(11).getValue());
      List<ViableConstructionTypes> newLandViableConstructionTypes =
          PrimitiveValueDecoders.fromList(ViableConstructionTypes.valueDecoder())
          .decode(fields$.get(12).getValue());
      String newLandAdditionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(13).getValue());
      String newLandDescription = PrimitiveValueDecoders.fromText
          .decode(fields$.get(14).getValue());
      List<String> newLandPhotoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(15).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(16).getValue());
      return new UpdateLand(newLandPrice, newLandPropertyAddress, newLandPropertyPostalCode,
          newLandPropertyDistrict, newLandPropertyCounty, newLandType, newLandTotalArea,
          newLandMinimumSurfaceForSale, newLandBuildableArea, newLandBuildableFloors,
          newLandAccessByRoad, newLandInstalledEquipment, newLandViableConstructionTypes,
          newLandAdditionalInformation, newLandDescription, newLandPhotoReferences, propertyKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(17);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandPrice", new Numeric(this.newLandPrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandPropertyAddress", new Text(this.newLandPropertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandPropertyPostalCode", new Text(this.newLandPropertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandPropertyDistrict", new Text(this.newLandPropertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandPropertyCounty", new Text(this.newLandPropertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandType", this.newLandType.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandTotalArea", new Numeric(this.newLandTotalArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandMinimumSurfaceForSale", new Numeric(this.newLandMinimumSurfaceForSale)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandBuildableArea", new Numeric(this.newLandBuildableArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandBuildableFloors", new Int64(this.newLandBuildableFloors)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandAccessByRoad", Bool.of(this.newLandAccessByRoad)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandInstalledEquipment", new Text(this.newLandInstalledEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandViableConstructionTypes", this.newLandViableConstructionTypes.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandAdditionalInformation", new Text(this.newLandAdditionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandDescription", new Text(this.newLandDescription)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandPhotoReferences", this.newLandPhotoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateLand> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newLandPrice", "newLandPropertyAddress", "newLandPropertyPostalCode", "newLandPropertyDistrict", "newLandPropertyCounty", "newLandType", "newLandTotalArea", "newLandMinimumSurfaceForSale", "newLandBuildableArea", "newLandBuildableFloors", "newLandAccessByRoad", "newLandInstalledEquipment", "newLandViableConstructionTypes", "newLandAdditionalInformation", "newLandDescription", "newLandPhotoReferences", "propertyKey"), name -> {
          switch (name) {
            case "newLandPrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newLandPropertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLandPropertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLandPropertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLandPropertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLandType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.interface$.propertymanager.property.common.LandType.jsonDecoder());
            case "newLandTotalArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newLandMinimumSurfaceForSale": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newLandBuildableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newLandBuildableFloors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newLandAccessByRoad": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            case "newLandInstalledEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLandViableConstructionTypes": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.interface$.propertymanager.property.common.ViableConstructionTypes.jsonDecoder()));
            case "newLandAdditionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLandDescription": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLandPhotoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, daml.interface$.common.types.PropertyKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateLand(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16])));
  }

  public static UpdateLand fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newLandPrice", apply(JsonLfEncoders::numeric, newLandPrice)),
        JsonLfEncoders.Field.of("newLandPropertyAddress", apply(JsonLfEncoders::text, newLandPropertyAddress)),
        JsonLfEncoders.Field.of("newLandPropertyPostalCode", apply(JsonLfEncoders::text, newLandPropertyPostalCode)),
        JsonLfEncoders.Field.of("newLandPropertyDistrict", apply(JsonLfEncoders::text, newLandPropertyDistrict)),
        JsonLfEncoders.Field.of("newLandPropertyCounty", apply(JsonLfEncoders::text, newLandPropertyCounty)),
        JsonLfEncoders.Field.of("newLandType", apply(LandType::jsonEncoder, newLandType)),
        JsonLfEncoders.Field.of("newLandTotalArea", apply(JsonLfEncoders::numeric, newLandTotalArea)),
        JsonLfEncoders.Field.of("newLandMinimumSurfaceForSale", apply(JsonLfEncoders::numeric, newLandMinimumSurfaceForSale)),
        JsonLfEncoders.Field.of("newLandBuildableArea", apply(JsonLfEncoders::numeric, newLandBuildableArea)),
        JsonLfEncoders.Field.of("newLandBuildableFloors", apply(JsonLfEncoders::int64, newLandBuildableFloors)),
        JsonLfEncoders.Field.of("newLandAccessByRoad", apply(JsonLfEncoders::bool, newLandAccessByRoad)),
        JsonLfEncoders.Field.of("newLandInstalledEquipment", apply(JsonLfEncoders::text, newLandInstalledEquipment)),
        JsonLfEncoders.Field.of("newLandViableConstructionTypes", apply(JsonLfEncoders.list(ViableConstructionTypes::jsonEncoder), newLandViableConstructionTypes)),
        JsonLfEncoders.Field.of("newLandAdditionalInformation", apply(JsonLfEncoders::text, newLandAdditionalInformation)),
        JsonLfEncoders.Field.of("newLandDescription", apply(JsonLfEncoders::text, newLandDescription)),
        JsonLfEncoders.Field.of("newLandPhotoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), newLandPhotoReferences)),
        JsonLfEncoders.Field.of("propertyKey", apply(PropertyKey::jsonEncoder, propertyKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateLand)) {
      return false;
    }
    UpdateLand other = (UpdateLand) object;
    return Objects.equals(this.newLandPrice, other.newLandPrice) &&
        Objects.equals(this.newLandPropertyAddress, other.newLandPropertyAddress) &&
        Objects.equals(this.newLandPropertyPostalCode, other.newLandPropertyPostalCode) &&
        Objects.equals(this.newLandPropertyDistrict, other.newLandPropertyDistrict) &&
        Objects.equals(this.newLandPropertyCounty, other.newLandPropertyCounty) &&
        Objects.equals(this.newLandType, other.newLandType) &&
        Objects.equals(this.newLandTotalArea, other.newLandTotalArea) &&
        Objects.equals(this.newLandMinimumSurfaceForSale, other.newLandMinimumSurfaceForSale) &&
        Objects.equals(this.newLandBuildableArea, other.newLandBuildableArea) &&
        Objects.equals(this.newLandBuildableFloors, other.newLandBuildableFloors) &&
        Objects.equals(this.newLandAccessByRoad, other.newLandAccessByRoad) &&
        Objects.equals(this.newLandInstalledEquipment, other.newLandInstalledEquipment) &&
        Objects.equals(this.newLandViableConstructionTypes, other.newLandViableConstructionTypes) &&
        Objects.equals(this.newLandAdditionalInformation, other.newLandAdditionalInformation) &&
        Objects.equals(this.newLandDescription, other.newLandDescription) &&
        Objects.equals(this.newLandPhotoReferences, other.newLandPhotoReferences) &&
        Objects.equals(this.propertyKey, other.propertyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newLandPrice, this.newLandPropertyAddress,
        this.newLandPropertyPostalCode, this.newLandPropertyDistrict, this.newLandPropertyCounty,
        this.newLandType, this.newLandTotalArea, this.newLandMinimumSurfaceForSale,
        this.newLandBuildableArea, this.newLandBuildableFloors, this.newLandAccessByRoad,
        this.newLandInstalledEquipment, this.newLandViableConstructionTypes,
        this.newLandAdditionalInformation, this.newLandDescription, this.newLandPhotoReferences,
        this.propertyKey);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.UpdateLand(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.newLandPrice, this.newLandPropertyAddress, this.newLandPropertyPostalCode,
        this.newLandPropertyDistrict, this.newLandPropertyCounty, this.newLandType,
        this.newLandTotalArea, this.newLandMinimumSurfaceForSale, this.newLandBuildableArea,
        this.newLandBuildableFloors, this.newLandAccessByRoad, this.newLandInstalledEquipment,
        this.newLandViableConstructionTypes, this.newLandAdditionalInformation,
        this.newLandDescription, this.newLandPhotoReferences, this.propertyKey);
  }
}
