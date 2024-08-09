package daml.interface$.propertymanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import java.util.Objects;

public class UpdateGarage extends DamlRecord<UpdateGarage> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final BigDecimal newGaragePrice;

  public final String newGaragePropertyAddress;

  public final String newGaragePropertyPostalCode;

  public final String newGaragePropertyDistrict;

  public final String newGaragePropertyCounty;

  public final BigDecimal newGarageArea;

  public final GarageType newGarageType;

  public final Long newGarageVehicleCapacity;

  public final String newGarageInstalledEquipment;

  public final String newGarageAdditionalInformation;

  public final String newGarageDescription;

  public final List<String> newGaragePhotoReferences;

  public final PropertyKey propertyKey;

  public UpdateGarage(BigDecimal newGaragePrice, String newGaragePropertyAddress,
      String newGaragePropertyPostalCode, String newGaragePropertyDistrict,
      String newGaragePropertyCounty, BigDecimal newGarageArea, GarageType newGarageType,
      Long newGarageVehicleCapacity, String newGarageInstalledEquipment,
      String newGarageAdditionalInformation, String newGarageDescription,
      List<String> newGaragePhotoReferences, PropertyKey propertyKey) {
    this.newGaragePrice = newGaragePrice;
    this.newGaragePropertyAddress = newGaragePropertyAddress;
    this.newGaragePropertyPostalCode = newGaragePropertyPostalCode;
    this.newGaragePropertyDistrict = newGaragePropertyDistrict;
    this.newGaragePropertyCounty = newGaragePropertyCounty;
    this.newGarageArea = newGarageArea;
    this.newGarageType = newGarageType;
    this.newGarageVehicleCapacity = newGarageVehicleCapacity;
    this.newGarageInstalledEquipment = newGarageInstalledEquipment;
    this.newGarageAdditionalInformation = newGarageAdditionalInformation;
    this.newGarageDescription = newGarageDescription;
    this.newGaragePhotoReferences = newGaragePhotoReferences;
    this.propertyKey = propertyKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateGarage fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateGarage> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(13,0,
          recordValue$);
      BigDecimal newGaragePrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      String newGaragePropertyAddress = PrimitiveValueDecoders.fromText
          .decode(fields$.get(1).getValue());
      String newGaragePropertyPostalCode = PrimitiveValueDecoders.fromText
          .decode(fields$.get(2).getValue());
      String newGaragePropertyDistrict = PrimitiveValueDecoders.fromText
          .decode(fields$.get(3).getValue());
      String newGaragePropertyCounty = PrimitiveValueDecoders.fromText
          .decode(fields$.get(4).getValue());
      BigDecimal newGarageArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(5).getValue());
      GarageType newGarageType = GarageType.valueDecoder().decode(fields$.get(6).getValue());
      Long newGarageVehicleCapacity = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(7).getValue());
      String newGarageInstalledEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(8).getValue());
      String newGarageAdditionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(9).getValue());
      String newGarageDescription = PrimitiveValueDecoders.fromText
          .decode(fields$.get(10).getValue());
      List<String> newGaragePhotoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(11).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(12).getValue());
      return new UpdateGarage(newGaragePrice, newGaragePropertyAddress, newGaragePropertyPostalCode,
          newGaragePropertyDistrict, newGaragePropertyCounty, newGarageArea, newGarageType,
          newGarageVehicleCapacity, newGarageInstalledEquipment, newGarageAdditionalInformation,
          newGarageDescription, newGaragePhotoReferences, propertyKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(13);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGaragePrice", new Numeric(this.newGaragePrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGaragePropertyAddress", new Text(this.newGaragePropertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGaragePropertyPostalCode", new Text(this.newGaragePropertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGaragePropertyDistrict", new Text(this.newGaragePropertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGaragePropertyCounty", new Text(this.newGaragePropertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageArea", new Numeric(this.newGarageArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageType", this.newGarageType.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageVehicleCapacity", new Int64(this.newGarageVehicleCapacity)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageInstalledEquipment", new Text(this.newGarageInstalledEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageAdditionalInformation", new Text(this.newGarageAdditionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageDescription", new Text(this.newGarageDescription)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGaragePhotoReferences", this.newGaragePhotoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateGarage> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newGaragePrice", "newGaragePropertyAddress", "newGaragePropertyPostalCode", "newGaragePropertyDistrict", "newGaragePropertyCounty", "newGarageArea", "newGarageType", "newGarageVehicleCapacity", "newGarageInstalledEquipment", "newGarageAdditionalInformation", "newGarageDescription", "newGaragePhotoReferences", "propertyKey"), name -> {
          switch (name) {
            case "newGaragePrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newGaragePropertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newGaragePropertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newGaragePropertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newGaragePropertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newGarageArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newGarageType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, daml.interface$.propertymanager.property.common.GarageType.jsonDecoder());
            case "newGarageVehicleCapacity": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newGarageInstalledEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newGarageAdditionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newGarageDescription": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newGaragePhotoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, daml.interface$.common.types.PropertyKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateGarage(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12])));
  }

  public static UpdateGarage fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newGaragePrice", apply(JsonLfEncoders::numeric, newGaragePrice)),
        JsonLfEncoders.Field.of("newGaragePropertyAddress", apply(JsonLfEncoders::text, newGaragePropertyAddress)),
        JsonLfEncoders.Field.of("newGaragePropertyPostalCode", apply(JsonLfEncoders::text, newGaragePropertyPostalCode)),
        JsonLfEncoders.Field.of("newGaragePropertyDistrict", apply(JsonLfEncoders::text, newGaragePropertyDistrict)),
        JsonLfEncoders.Field.of("newGaragePropertyCounty", apply(JsonLfEncoders::text, newGaragePropertyCounty)),
        JsonLfEncoders.Field.of("newGarageArea", apply(JsonLfEncoders::numeric, newGarageArea)),
        JsonLfEncoders.Field.of("newGarageType", apply(GarageType::jsonEncoder, newGarageType)),
        JsonLfEncoders.Field.of("newGarageVehicleCapacity", apply(JsonLfEncoders::int64, newGarageVehicleCapacity)),
        JsonLfEncoders.Field.of("newGarageInstalledEquipment", apply(JsonLfEncoders::text, newGarageInstalledEquipment)),
        JsonLfEncoders.Field.of("newGarageAdditionalInformation", apply(JsonLfEncoders::text, newGarageAdditionalInformation)),
        JsonLfEncoders.Field.of("newGarageDescription", apply(JsonLfEncoders::text, newGarageDescription)),
        JsonLfEncoders.Field.of("newGaragePhotoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), newGaragePhotoReferences)),
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
    if (!(object instanceof UpdateGarage)) {
      return false;
    }
    UpdateGarage other = (UpdateGarage) object;
    return Objects.equals(this.newGaragePrice, other.newGaragePrice) &&
        Objects.equals(this.newGaragePropertyAddress, other.newGaragePropertyAddress) &&
        Objects.equals(this.newGaragePropertyPostalCode, other.newGaragePropertyPostalCode) &&
        Objects.equals(this.newGaragePropertyDistrict, other.newGaragePropertyDistrict) &&
        Objects.equals(this.newGaragePropertyCounty, other.newGaragePropertyCounty) &&
        Objects.equals(this.newGarageArea, other.newGarageArea) &&
        Objects.equals(this.newGarageType, other.newGarageType) &&
        Objects.equals(this.newGarageVehicleCapacity, other.newGarageVehicleCapacity) &&
        Objects.equals(this.newGarageInstalledEquipment, other.newGarageInstalledEquipment) &&
        Objects.equals(this.newGarageAdditionalInformation, other.newGarageAdditionalInformation) &&
        Objects.equals(this.newGarageDescription, other.newGarageDescription) &&
        Objects.equals(this.newGaragePhotoReferences, other.newGaragePhotoReferences) &&
        Objects.equals(this.propertyKey, other.propertyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newGaragePrice, this.newGaragePropertyAddress,
        this.newGaragePropertyPostalCode, this.newGaragePropertyDistrict,
        this.newGaragePropertyCounty, this.newGarageArea, this.newGarageType,
        this.newGarageVehicleCapacity, this.newGarageInstalledEquipment,
        this.newGarageAdditionalInformation, this.newGarageDescription,
        this.newGaragePhotoReferences, this.propertyKey);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.UpdateGarage(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.newGaragePrice, this.newGaragePropertyAddress, this.newGaragePropertyPostalCode,
        this.newGaragePropertyDistrict, this.newGaragePropertyCounty, this.newGarageArea,
        this.newGarageType, this.newGarageVehicleCapacity, this.newGarageInstalledEquipment,
        this.newGarageAdditionalInformation, this.newGarageDescription,
        this.newGaragePhotoReferences, this.propertyKey);
  }
}
