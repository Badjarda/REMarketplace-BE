package daml.interface$.propertymanager.property.residenceproperty.residenceproperty;

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
import java.util.Objects;

public class UpdateResidence extends DamlRecord<UpdateResidence> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final BigDecimal newResidencePrice;

  public final String newResidencePropertyAddress;

  public final String newResidencePropertyPostalCode;

  public final String newResidencePropertyDistrict;

  public final String newResidencePropertyCounty;

  public final BigDecimal newResidenceGrossArea;

  public final BigDecimal newResidenceUsableArea;

  public final Long newResidenceBedrooms;

  public final Long newResidenceBathrooms;

  public final Long newResidenceFloors;

  public final ResidenceType newResidenceType;

  public final String newResidenceBackyard;

  public final Parking newResidenceParking;

  public final LocalDate newResidenceBuildDate;

  public final Orientation newResidenceOrientation;

  public final String newResidenceInstalledEquipment;

  public final String newResidenceAdditionalInformation;

  public final String newResidenceDescription;

  public final List<String> newResidencePhotoReferences;

  public UpdateResidence(BigDecimal newResidencePrice, String newResidencePropertyAddress,
      String newResidencePropertyPostalCode, String newResidencePropertyDistrict,
      String newResidencePropertyCounty, BigDecimal newResidenceGrossArea,
      BigDecimal newResidenceUsableArea, Long newResidenceBedrooms, Long newResidenceBathrooms,
      Long newResidenceFloors, ResidenceType newResidenceType, String newResidenceBackyard,
      Parking newResidenceParking, LocalDate newResidenceBuildDate,
      Orientation newResidenceOrientation, String newResidenceInstalledEquipment,
      String newResidenceAdditionalInformation, String newResidenceDescription,
      List<String> newResidencePhotoReferences) {
    this.newResidencePrice = newResidencePrice;
    this.newResidencePropertyAddress = newResidencePropertyAddress;
    this.newResidencePropertyPostalCode = newResidencePropertyPostalCode;
    this.newResidencePropertyDistrict = newResidencePropertyDistrict;
    this.newResidencePropertyCounty = newResidencePropertyCounty;
    this.newResidenceGrossArea = newResidenceGrossArea;
    this.newResidenceUsableArea = newResidenceUsableArea;
    this.newResidenceBedrooms = newResidenceBedrooms;
    this.newResidenceBathrooms = newResidenceBathrooms;
    this.newResidenceFloors = newResidenceFloors;
    this.newResidenceType = newResidenceType;
    this.newResidenceBackyard = newResidenceBackyard;
    this.newResidenceParking = newResidenceParking;
    this.newResidenceBuildDate = newResidenceBuildDate;
    this.newResidenceOrientation = newResidenceOrientation;
    this.newResidenceInstalledEquipment = newResidenceInstalledEquipment;
    this.newResidenceAdditionalInformation = newResidenceAdditionalInformation;
    this.newResidenceDescription = newResidenceDescription;
    this.newResidencePhotoReferences = newResidencePhotoReferences;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateResidence fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateResidence> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(19,0,
          recordValue$);
      BigDecimal newResidencePrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      String newResidencePropertyAddress = PrimitiveValueDecoders.fromText
          .decode(fields$.get(1).getValue());
      String newResidencePropertyPostalCode = PrimitiveValueDecoders.fromText
          .decode(fields$.get(2).getValue());
      String newResidencePropertyDistrict = PrimitiveValueDecoders.fromText
          .decode(fields$.get(3).getValue());
      String newResidencePropertyCounty = PrimitiveValueDecoders.fromText
          .decode(fields$.get(4).getValue());
      BigDecimal newResidenceGrossArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(5).getValue());
      BigDecimal newResidenceUsableArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(6).getValue());
      Long newResidenceBedrooms = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(7).getValue());
      Long newResidenceBathrooms = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(8).getValue());
      Long newResidenceFloors = PrimitiveValueDecoders.fromInt64.decode(fields$.get(9).getValue());
      ResidenceType newResidenceType = ResidenceType.valueDecoder()
          .decode(fields$.get(10).getValue());
      String newResidenceBackyard = PrimitiveValueDecoders.fromText
          .decode(fields$.get(11).getValue());
      Parking newResidenceParking = Parking.valueDecoder().decode(fields$.get(12).getValue());
      LocalDate newResidenceBuildDate = PrimitiveValueDecoders.fromDate
          .decode(fields$.get(13).getValue());
      Orientation newResidenceOrientation = Orientation.valueDecoder()
          .decode(fields$.get(14).getValue());
      String newResidenceInstalledEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(15).getValue());
      String newResidenceAdditionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(16).getValue());
      String newResidenceDescription = PrimitiveValueDecoders.fromText
          .decode(fields$.get(17).getValue());
      List<String> newResidencePhotoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(18).getValue());
      return new UpdateResidence(newResidencePrice, newResidencePropertyAddress,
          newResidencePropertyPostalCode, newResidencePropertyDistrict, newResidencePropertyCounty,
          newResidenceGrossArea, newResidenceUsableArea, newResidenceBedrooms,
          newResidenceBathrooms, newResidenceFloors, newResidenceType, newResidenceBackyard,
          newResidenceParking, newResidenceBuildDate, newResidenceOrientation,
          newResidenceInstalledEquipment, newResidenceAdditionalInformation,
          newResidenceDescription, newResidencePhotoReferences);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(19);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePrice", new Numeric(this.newResidencePrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePropertyAddress", new Text(this.newResidencePropertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePropertyPostalCode", new Text(this.newResidencePropertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePropertyDistrict", new Text(this.newResidencePropertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePropertyCounty", new Text(this.newResidencePropertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceGrossArea", new Numeric(this.newResidenceGrossArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceUsableArea", new Numeric(this.newResidenceUsableArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceBedrooms", new Int64(this.newResidenceBedrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceBathrooms", new Int64(this.newResidenceBathrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceFloors", new Int64(this.newResidenceFloors)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceType", this.newResidenceType.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceBackyard", new Text(this.newResidenceBackyard)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceParking", this.newResidenceParking.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceBuildDate", new Date((int) this.newResidenceBuildDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceOrientation", this.newResidenceOrientation.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceInstalledEquipment", new Text(this.newResidenceInstalledEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceAdditionalInformation", new Text(this.newResidenceAdditionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceDescription", new Text(this.newResidenceDescription)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePhotoReferences", this.newResidencePhotoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateResidence> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newResidencePrice", "newResidencePropertyAddress", "newResidencePropertyPostalCode", "newResidencePropertyDistrict", "newResidencePropertyCounty", "newResidenceGrossArea", "newResidenceUsableArea", "newResidenceBedrooms", "newResidenceBathrooms", "newResidenceFloors", "newResidenceType", "newResidenceBackyard", "newResidenceParking", "newResidenceBuildDate", "newResidenceOrientation", "newResidenceInstalledEquipment", "newResidenceAdditionalInformation", "newResidenceDescription", "newResidencePhotoReferences"), name -> {
          switch (name) {
            case "newResidencePrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newResidencePropertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidencePropertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidencePropertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidencePropertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidenceGrossArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newResidenceUsableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newResidenceBedrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newResidenceBathrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newResidenceFloors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newResidenceType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, daml.interface$.propertymanager.property.common.ResidenceType.jsonDecoder());
            case "newResidenceBackyard": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidenceParking": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, daml.interface$.propertymanager.property.common.Parking.jsonDecoder());
            case "newResidenceBuildDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "newResidenceOrientation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, daml.interface$.propertymanager.property.common.Orientation.jsonDecoder());
            case "newResidenceInstalledEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidenceAdditionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidenceDescription": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(17, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newResidencePhotoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(18, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateResidence(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16]), JsonLfDecoders.cast(args[17]), JsonLfDecoders.cast(args[18])));
  }

  public static UpdateResidence fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newResidencePrice", apply(JsonLfEncoders::numeric, newResidencePrice)),
        JsonLfEncoders.Field.of("newResidencePropertyAddress", apply(JsonLfEncoders::text, newResidencePropertyAddress)),
        JsonLfEncoders.Field.of("newResidencePropertyPostalCode", apply(JsonLfEncoders::text, newResidencePropertyPostalCode)),
        JsonLfEncoders.Field.of("newResidencePropertyDistrict", apply(JsonLfEncoders::text, newResidencePropertyDistrict)),
        JsonLfEncoders.Field.of("newResidencePropertyCounty", apply(JsonLfEncoders::text, newResidencePropertyCounty)),
        JsonLfEncoders.Field.of("newResidenceGrossArea", apply(JsonLfEncoders::numeric, newResidenceGrossArea)),
        JsonLfEncoders.Field.of("newResidenceUsableArea", apply(JsonLfEncoders::numeric, newResidenceUsableArea)),
        JsonLfEncoders.Field.of("newResidenceBedrooms", apply(JsonLfEncoders::int64, newResidenceBedrooms)),
        JsonLfEncoders.Field.of("newResidenceBathrooms", apply(JsonLfEncoders::int64, newResidenceBathrooms)),
        JsonLfEncoders.Field.of("newResidenceFloors", apply(JsonLfEncoders::int64, newResidenceFloors)),
        JsonLfEncoders.Field.of("newResidenceType", apply(ResidenceType::jsonEncoder, newResidenceType)),
        JsonLfEncoders.Field.of("newResidenceBackyard", apply(JsonLfEncoders::text, newResidenceBackyard)),
        JsonLfEncoders.Field.of("newResidenceParking", apply(Parking::jsonEncoder, newResidenceParking)),
        JsonLfEncoders.Field.of("newResidenceBuildDate", apply(JsonLfEncoders::date, newResidenceBuildDate)),
        JsonLfEncoders.Field.of("newResidenceOrientation", apply(Orientation::jsonEncoder, newResidenceOrientation)),
        JsonLfEncoders.Field.of("newResidenceInstalledEquipment", apply(JsonLfEncoders::text, newResidenceInstalledEquipment)),
        JsonLfEncoders.Field.of("newResidenceAdditionalInformation", apply(JsonLfEncoders::text, newResidenceAdditionalInformation)),
        JsonLfEncoders.Field.of("newResidenceDescription", apply(JsonLfEncoders::text, newResidenceDescription)),
        JsonLfEncoders.Field.of("newResidencePhotoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), newResidencePhotoReferences)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateResidence)) {
      return false;
    }
    UpdateResidence other = (UpdateResidence) object;
    return Objects.equals(this.newResidencePrice, other.newResidencePrice) &&
        Objects.equals(this.newResidencePropertyAddress, other.newResidencePropertyAddress) &&
        Objects.equals(this.newResidencePropertyPostalCode, other.newResidencePropertyPostalCode) &&
        Objects.equals(this.newResidencePropertyDistrict, other.newResidencePropertyDistrict) &&
        Objects.equals(this.newResidencePropertyCounty, other.newResidencePropertyCounty) &&
        Objects.equals(this.newResidenceGrossArea, other.newResidenceGrossArea) &&
        Objects.equals(this.newResidenceUsableArea, other.newResidenceUsableArea) &&
        Objects.equals(this.newResidenceBedrooms, other.newResidenceBedrooms) &&
        Objects.equals(this.newResidenceBathrooms, other.newResidenceBathrooms) &&
        Objects.equals(this.newResidenceFloors, other.newResidenceFloors) &&
        Objects.equals(this.newResidenceType, other.newResidenceType) &&
        Objects.equals(this.newResidenceBackyard, other.newResidenceBackyard) &&
        Objects.equals(this.newResidenceParking, other.newResidenceParking) &&
        Objects.equals(this.newResidenceBuildDate, other.newResidenceBuildDate) &&
        Objects.equals(this.newResidenceOrientation, other.newResidenceOrientation) &&
        Objects.equals(this.newResidenceInstalledEquipment, other.newResidenceInstalledEquipment) &&
        Objects.equals(this.newResidenceAdditionalInformation, other.newResidenceAdditionalInformation) &&
        Objects.equals(this.newResidenceDescription, other.newResidenceDescription) &&
        Objects.equals(this.newResidencePhotoReferences, other.newResidencePhotoReferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newResidencePrice, this.newResidencePropertyAddress,
        this.newResidencePropertyPostalCode, this.newResidencePropertyDistrict,
        this.newResidencePropertyCounty, this.newResidenceGrossArea, this.newResidenceUsableArea,
        this.newResidenceBedrooms, this.newResidenceBathrooms, this.newResidenceFloors,
        this.newResidenceType, this.newResidenceBackyard, this.newResidenceParking,
        this.newResidenceBuildDate, this.newResidenceOrientation,
        this.newResidenceInstalledEquipment, this.newResidenceAdditionalInformation,
        this.newResidenceDescription, this.newResidencePhotoReferences);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.residenceproperty.residenceproperty.UpdateResidence(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.newResidencePrice, this.newResidencePropertyAddress,
        this.newResidencePropertyPostalCode, this.newResidencePropertyDistrict,
        this.newResidencePropertyCounty, this.newResidenceGrossArea, this.newResidenceUsableArea,
        this.newResidenceBedrooms, this.newResidenceBathrooms, this.newResidenceFloors,
        this.newResidenceType, this.newResidenceBackyard, this.newResidenceParking,
        this.newResidenceBuildDate, this.newResidenceOrientation,
        this.newResidenceInstalledEquipment, this.newResidenceAdditionalInformation,
        this.newResidenceDescription, this.newResidencePhotoReferences);
  }
}
