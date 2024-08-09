package daml.interface$.propertymanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Date;
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
import daml.interface$.propertymanager.property.common.WarehouseType;
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
import java.util.Objects;

public class UpdateWarehouse extends DamlRecord<UpdateWarehouse> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final BigDecimal newWarehousePrice;

  public final String newWarehousePropertyAddress;

  public final String newWarehousePropertyPostalCode;

  public final String newWarehousePropertyDistrict;

  public final String newWarehousePropertyCounty;

  public final WarehouseType newWarehouseType;

  public final BigDecimal newWarehouseGrossArea;

  public final BigDecimal newWarehouseUsableArea;

  public final Long newWarehouseFloors;

  public final LocalDate newWarehouseBuildDate;

  public final String newWarehouseInstalledEquipment;

  public final String newWarehouseAdditionalInformation;

  public final String newWarehouseDescription;

  public final List<String> newWarehousePhotoReferences;

  public final PropertyKey propertyKey;

  public UpdateWarehouse(BigDecimal newWarehousePrice, String newWarehousePropertyAddress,
      String newWarehousePropertyPostalCode, String newWarehousePropertyDistrict,
      String newWarehousePropertyCounty, WarehouseType newWarehouseType,
      BigDecimal newWarehouseGrossArea, BigDecimal newWarehouseUsableArea, Long newWarehouseFloors,
      LocalDate newWarehouseBuildDate, String newWarehouseInstalledEquipment,
      String newWarehouseAdditionalInformation, String newWarehouseDescription,
      List<String> newWarehousePhotoReferences, PropertyKey propertyKey) {
    this.newWarehousePrice = newWarehousePrice;
    this.newWarehousePropertyAddress = newWarehousePropertyAddress;
    this.newWarehousePropertyPostalCode = newWarehousePropertyPostalCode;
    this.newWarehousePropertyDistrict = newWarehousePropertyDistrict;
    this.newWarehousePropertyCounty = newWarehousePropertyCounty;
    this.newWarehouseType = newWarehouseType;
    this.newWarehouseGrossArea = newWarehouseGrossArea;
    this.newWarehouseUsableArea = newWarehouseUsableArea;
    this.newWarehouseFloors = newWarehouseFloors;
    this.newWarehouseBuildDate = newWarehouseBuildDate;
    this.newWarehouseInstalledEquipment = newWarehouseInstalledEquipment;
    this.newWarehouseAdditionalInformation = newWarehouseAdditionalInformation;
    this.newWarehouseDescription = newWarehouseDescription;
    this.newWarehousePhotoReferences = newWarehousePhotoReferences;
    this.propertyKey = propertyKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateWarehouse fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateWarehouse> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(15,0,
          recordValue$);
      BigDecimal newWarehousePrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      String newWarehousePropertyAddress = PrimitiveValueDecoders.fromText
          .decode(fields$.get(1).getValue());
      String newWarehousePropertyPostalCode = PrimitiveValueDecoders.fromText
          .decode(fields$.get(2).getValue());
      String newWarehousePropertyDistrict = PrimitiveValueDecoders.fromText
          .decode(fields$.get(3).getValue());
      String newWarehousePropertyCounty = PrimitiveValueDecoders.fromText
          .decode(fields$.get(4).getValue());
      WarehouseType newWarehouseType = WarehouseType.valueDecoder()
          .decode(fields$.get(5).getValue());
      BigDecimal newWarehouseGrossArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(6).getValue());
      BigDecimal newWarehouseUsableArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(7).getValue());
      Long newWarehouseFloors = PrimitiveValueDecoders.fromInt64.decode(fields$.get(8).getValue());
      LocalDate newWarehouseBuildDate = PrimitiveValueDecoders.fromDate
          .decode(fields$.get(9).getValue());
      String newWarehouseInstalledEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(10).getValue());
      String newWarehouseAdditionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(11).getValue());
      String newWarehouseDescription = PrimitiveValueDecoders.fromText
          .decode(fields$.get(12).getValue());
      List<String> newWarehousePhotoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(13).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(14).getValue());
      return new UpdateWarehouse(newWarehousePrice, newWarehousePropertyAddress,
          newWarehousePropertyPostalCode, newWarehousePropertyDistrict, newWarehousePropertyCounty,
          newWarehouseType, newWarehouseGrossArea, newWarehouseUsableArea, newWarehouseFloors,
          newWarehouseBuildDate, newWarehouseInstalledEquipment, newWarehouseAdditionalInformation,
          newWarehouseDescription, newWarehousePhotoReferences, propertyKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(15);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePrice", new Numeric(this.newWarehousePrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePropertyAddress", new Text(this.newWarehousePropertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePropertyPostalCode", new Text(this.newWarehousePropertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePropertyDistrict", new Text(this.newWarehousePropertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePropertyCounty", new Text(this.newWarehousePropertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseType", this.newWarehouseType.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseGrossArea", new Numeric(this.newWarehouseGrossArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseUsableArea", new Numeric(this.newWarehouseUsableArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseFloors", new Int64(this.newWarehouseFloors)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseBuildDate", new Date((int) this.newWarehouseBuildDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseInstalledEquipment", new Text(this.newWarehouseInstalledEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseAdditionalInformation", new Text(this.newWarehouseAdditionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseDescription", new Text(this.newWarehouseDescription)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePhotoReferences", this.newWarehousePhotoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateWarehouse> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newWarehousePrice", "newWarehousePropertyAddress", "newWarehousePropertyPostalCode", "newWarehousePropertyDistrict", "newWarehousePropertyCounty", "newWarehouseType", "newWarehouseGrossArea", "newWarehouseUsableArea", "newWarehouseFloors", "newWarehouseBuildDate", "newWarehouseInstalledEquipment", "newWarehouseAdditionalInformation", "newWarehouseDescription", "newWarehousePhotoReferences", "propertyKey"), name -> {
          switch (name) {
            case "newWarehousePrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newWarehousePropertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newWarehousePropertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newWarehousePropertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newWarehousePropertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newWarehouseType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.interface$.propertymanager.property.common.WarehouseType.jsonDecoder());
            case "newWarehouseGrossArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newWarehouseUsableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newWarehouseFloors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newWarehouseBuildDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "newWarehouseInstalledEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newWarehouseAdditionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newWarehouseDescription": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newWarehousePhotoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, daml.interface$.common.types.PropertyKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateWarehouse(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14])));
  }

  public static UpdateWarehouse fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newWarehousePrice", apply(JsonLfEncoders::numeric, newWarehousePrice)),
        JsonLfEncoders.Field.of("newWarehousePropertyAddress", apply(JsonLfEncoders::text, newWarehousePropertyAddress)),
        JsonLfEncoders.Field.of("newWarehousePropertyPostalCode", apply(JsonLfEncoders::text, newWarehousePropertyPostalCode)),
        JsonLfEncoders.Field.of("newWarehousePropertyDistrict", apply(JsonLfEncoders::text, newWarehousePropertyDistrict)),
        JsonLfEncoders.Field.of("newWarehousePropertyCounty", apply(JsonLfEncoders::text, newWarehousePropertyCounty)),
        JsonLfEncoders.Field.of("newWarehouseType", apply(WarehouseType::jsonEncoder, newWarehouseType)),
        JsonLfEncoders.Field.of("newWarehouseGrossArea", apply(JsonLfEncoders::numeric, newWarehouseGrossArea)),
        JsonLfEncoders.Field.of("newWarehouseUsableArea", apply(JsonLfEncoders::numeric, newWarehouseUsableArea)),
        JsonLfEncoders.Field.of("newWarehouseFloors", apply(JsonLfEncoders::int64, newWarehouseFloors)),
        JsonLfEncoders.Field.of("newWarehouseBuildDate", apply(JsonLfEncoders::date, newWarehouseBuildDate)),
        JsonLfEncoders.Field.of("newWarehouseInstalledEquipment", apply(JsonLfEncoders::text, newWarehouseInstalledEquipment)),
        JsonLfEncoders.Field.of("newWarehouseAdditionalInformation", apply(JsonLfEncoders::text, newWarehouseAdditionalInformation)),
        JsonLfEncoders.Field.of("newWarehouseDescription", apply(JsonLfEncoders::text, newWarehouseDescription)),
        JsonLfEncoders.Field.of("newWarehousePhotoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), newWarehousePhotoReferences)),
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
    if (!(object instanceof UpdateWarehouse)) {
      return false;
    }
    UpdateWarehouse other = (UpdateWarehouse) object;
    return Objects.equals(this.newWarehousePrice, other.newWarehousePrice) &&
        Objects.equals(this.newWarehousePropertyAddress, other.newWarehousePropertyAddress) &&
        Objects.equals(this.newWarehousePropertyPostalCode, other.newWarehousePropertyPostalCode) &&
        Objects.equals(this.newWarehousePropertyDistrict, other.newWarehousePropertyDistrict) &&
        Objects.equals(this.newWarehousePropertyCounty, other.newWarehousePropertyCounty) &&
        Objects.equals(this.newWarehouseType, other.newWarehouseType) &&
        Objects.equals(this.newWarehouseGrossArea, other.newWarehouseGrossArea) &&
        Objects.equals(this.newWarehouseUsableArea, other.newWarehouseUsableArea) &&
        Objects.equals(this.newWarehouseFloors, other.newWarehouseFloors) &&
        Objects.equals(this.newWarehouseBuildDate, other.newWarehouseBuildDate) &&
        Objects.equals(this.newWarehouseInstalledEquipment, other.newWarehouseInstalledEquipment) &&
        Objects.equals(this.newWarehouseAdditionalInformation, other.newWarehouseAdditionalInformation) &&
        Objects.equals(this.newWarehouseDescription, other.newWarehouseDescription) &&
        Objects.equals(this.newWarehousePhotoReferences, other.newWarehousePhotoReferences) &&
        Objects.equals(this.propertyKey, other.propertyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newWarehousePrice, this.newWarehousePropertyAddress,
        this.newWarehousePropertyPostalCode, this.newWarehousePropertyDistrict,
        this.newWarehousePropertyCounty, this.newWarehouseType, this.newWarehouseGrossArea,
        this.newWarehouseUsableArea, this.newWarehouseFloors, this.newWarehouseBuildDate,
        this.newWarehouseInstalledEquipment, this.newWarehouseAdditionalInformation,
        this.newWarehouseDescription, this.newWarehousePhotoReferences, this.propertyKey);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.UpdateWarehouse(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.newWarehousePrice, this.newWarehousePropertyAddress,
        this.newWarehousePropertyPostalCode, this.newWarehousePropertyDistrict,
        this.newWarehousePropertyCounty, this.newWarehouseType, this.newWarehouseGrossArea,
        this.newWarehouseUsableArea, this.newWarehouseFloors, this.newWarehouseBuildDate,
        this.newWarehouseInstalledEquipment, this.newWarehouseAdditionalInformation,
        this.newWarehouseDescription, this.newWarehousePhotoReferences, this.propertyKey);
  }
}
