package daml.app.propertymanager.property.landproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractWithKey;
import com.daml.ledger.javaapi.data.codegen.Created;
import com.daml.ledger.javaapi.data.codegen.Exercised;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.da.set.types.Set;
import daml.da.types.Tuple3;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.util.disclosure.Disclosure;
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
import java.util.Optional;

public final class LandProperty extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "App.PropertyManager.Property.LandProperty", "LandProperty");

  public static final Choice<LandProperty, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, LandProperty, Tuple3<String, String, Id>> COMPANION = 
      new ContractCompanion.WithKey<>("daml.app.propertymanager.property.landproperty.LandProperty",
        TEMPLATE_ID, ContractId::new, v -> LandProperty.templateValueDecoder().decode(v),
        LandProperty::fromJson, Contract::new, List.of(CHOICE_Archive),
        e -> Tuple3.<java.lang.String, java.lang.String,
        daml.daml.finance.interface$.types.common.types.Id>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromParty, Id.valueDecoder()).decode(e));

  public final String operator;

  public final String user;

  public final Id id;

  public final InstrumentKey instrument;

  public final BigDecimal landPrice;

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

  public LandProperty(String operator, String user, Id id, InstrumentKey instrument,
      BigDecimal landPrice, String propertyAddress, String propertyPostalCode,
      String propertyDistrict, String propertyCounty, LandType landType, BigDecimal totalLandArea,
      BigDecimal minimumSurfaceForSale, BigDecimal buildableArea, Long buildableFloors,
      Boolean accessByRoad, String installedEquipment,
      List<ViableConstructionTypes> viableConstructionTypes, String additionalInformation,
      String description, List<String> photoReferences, Map<String, Set<String>> observers) {
    this.operator = operator;
    this.user = user;
    this.id = id;
    this.instrument = instrument;
    this.landPrice = landPrice;
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

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(LandProperty.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple3<String, String, Id> key,
      daml.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple3<String, String, Id> key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive(daml.da.internal.template.Archive arg) {
    return createAnd().exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive() {
    return createAndExerciseArchive(new daml.da.internal.template.Archive());
  }

  public static Update<Created<ContractId>> create(String operator, String user, Id id,
      InstrumentKey instrument, BigDecimal landPrice, String propertyAddress,
      String propertyPostalCode, String propertyDistrict, String propertyCounty, LandType landType,
      BigDecimal totalLandArea, BigDecimal minimumSurfaceForSale, BigDecimal buildableArea,
      Long buildableFloors, Boolean accessByRoad, String installedEquipment,
      List<ViableConstructionTypes> viableConstructionTypes, String additionalInformation,
      String description, List<String> photoReferences, Map<String, Set<String>> observers) {
    return new LandProperty(operator, user, id, instrument, landPrice, propertyAddress,
        propertyPostalCode, propertyDistrict, propertyCounty, landType, totalLandArea,
        minimumSurfaceForSale, buildableArea, buildableFloors, accessByRoad, installedEquipment,
        viableConstructionTypes, additionalInformation, description, photoReferences,
        observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, LandProperty, Tuple3<String, String, Id>> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static LandProperty fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<LandProperty> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(21);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("user", new Party(this.user)));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("instrument", this.instrument.toValue()));
    fields.add(new DamlRecord.Field("landPrice", new Numeric(this.landPrice)));
    fields.add(new DamlRecord.Field("propertyAddress", new Text(this.propertyAddress)));
    fields.add(new DamlRecord.Field("propertyPostalCode", new Text(this.propertyPostalCode)));
    fields.add(new DamlRecord.Field("propertyDistrict", new Text(this.propertyDistrict)));
    fields.add(new DamlRecord.Field("propertyCounty", new Text(this.propertyCounty)));
    fields.add(new DamlRecord.Field("landType", this.landType.toValue()));
    fields.add(new DamlRecord.Field("totalLandArea", new Numeric(this.totalLandArea)));
    fields.add(new DamlRecord.Field("minimumSurfaceForSale", new Numeric(this.minimumSurfaceForSale)));
    fields.add(new DamlRecord.Field("buildableArea", new Numeric(this.buildableArea)));
    fields.add(new DamlRecord.Field("buildableFloors", new Int64(this.buildableFloors)));
    fields.add(new DamlRecord.Field("accessByRoad", Bool.of(this.accessByRoad)));
    fields.add(new DamlRecord.Field("installedEquipment", new Text(this.installedEquipment)));
    fields.add(new DamlRecord.Field("viableConstructionTypes", this.viableConstructionTypes.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    fields.add(new DamlRecord.Field("additionalInformation", new Text(this.additionalInformation)));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("photoReferences", this.photoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<LandProperty> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(21,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(3).getValue());
      BigDecimal landPrice = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(4).getValue());
      String propertyAddress = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      String propertyPostalCode = PrimitiveValueDecoders.fromText.decode(fields$.get(6).getValue());
      String propertyDistrict = PrimitiveValueDecoders.fromText.decode(fields$.get(7).getValue());
      String propertyCounty = PrimitiveValueDecoders.fromText.decode(fields$.get(8).getValue());
      LandType landType = LandType.valueDecoder().decode(fields$.get(9).getValue());
      BigDecimal totalLandArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(10).getValue());
      BigDecimal minimumSurfaceForSale = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(11).getValue());
      BigDecimal buildableArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(12).getValue());
      Long buildableFloors = PrimitiveValueDecoders.fromInt64.decode(fields$.get(13).getValue());
      Boolean accessByRoad = PrimitiveValueDecoders.fromBool.decode(fields$.get(14).getValue());
      String installedEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(15).getValue());
      List<ViableConstructionTypes> viableConstructionTypes = PrimitiveValueDecoders.fromList(
            ViableConstructionTypes.valueDecoder()).decode(fields$.get(16).getValue());
      String additionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(17).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(18).getValue());
      List<String> photoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(19).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(20).getValue());
      return new LandProperty(operator, user, id, instrument, landPrice, propertyAddress,
          propertyPostalCode, propertyDistrict, propertyCounty, landType, totalLandArea,
          minimumSurfaceForSale, buildableArea, buildableFloors, accessByRoad, installedEquipment,
          viableConstructionTypes, additionalInformation, description, photoReferences, observers);
    } ;
  }

  public static JsonLfDecoder<LandProperty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "user", "id", "instrument", "landPrice", "propertyAddress", "propertyPostalCode", "propertyDistrict", "propertyCounty", "landType", "totalLandArea", "minimumSurfaceForSale", "buildableArea", "buildableFloors", "accessByRoad", "installedEquipment", "viableConstructionTypes", "additionalInformation", "description", "photoReferences", "observers"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "landPrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "propertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "landType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, daml.interface$.propertymanager.property.common.LandType.jsonDecoder());
            case "totalLandArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "minimumSurfaceForSale": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "buildableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "buildableFloors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "accessByRoad": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            case "installedEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "viableConstructionTypes": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.interface$.propertymanager.property.common.ViableConstructionTypes.jsonDecoder()));
            case "additionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(17, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(18, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "photoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(19, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(20, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new LandProperty(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16]), JsonLfDecoders.cast(args[17]), JsonLfDecoders.cast(args[18]), JsonLfDecoders.cast(args[19]), JsonLfDecoders.cast(args[20])));
  }

  public static LandProperty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)),
        JsonLfEncoders.Field.of("landPrice", apply(JsonLfEncoders::numeric, landPrice)),
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

  public static ContractFilter<Contract> contractFilter() {
    return ContractFilter.of(COMPANION);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof LandProperty)) {
      return false;
    }
    LandProperty other = (LandProperty) object;
    return Objects.equals(this.operator, other.operator) && Objects.equals(this.user, other.user) &&
        Objects.equals(this.id, other.id) && Objects.equals(this.instrument, other.instrument) &&
        Objects.equals(this.landPrice, other.landPrice) &&
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
    return Objects.hash(this.operator, this.user, this.id, this.instrument, this.landPrice,
        this.propertyAddress, this.propertyPostalCode, this.propertyDistrict, this.propertyCounty,
        this.landType, this.totalLandArea, this.minimumSurfaceForSale, this.buildableArea,
        this.buildableFloors, this.accessByRoad, this.installedEquipment,
        this.viableConstructionTypes, this.additionalInformation, this.description,
        this.photoReferences, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.app.propertymanager.property.landproperty.LandProperty(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.user, this.id, this.instrument, this.landPrice, this.propertyAddress,
        this.propertyPostalCode, this.propertyDistrict, this.propertyCounty, this.landType,
        this.totalLandArea, this.minimumSurfaceForSale, this.buildableArea, this.buildableFloors,
        this.accessByRoad, this.installedEquipment, this.viableConstructionTypes,
        this.additionalInformation, this.description, this.photoReferences, this.observers);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(Tuple3<String, String, Id> key) {
    return new ByKey(key.toValue(v$0 -> new Party(v$0), v$1 -> new Party(v$1),
        v$2 -> v$2.toValue()));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<LandProperty> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LandProperty, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.ContractId toInterface(
        daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.ContractId(this.contractId);
    }

    public Disclosure.ContractId toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Disclosure.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<LandProperty> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, LandProperty, Tuple3<String, String, Id>> {
    public Contract(ContractId id, LandProperty data, Optional<String> agreementText,
        Optional<Tuple3<String, String, Id>> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, LandProperty> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<Tuple3<String, String, Id>> key,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LandProperty, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.CreateAnd toInterface(
        daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.CreateAnd(COMPANION, this.createArguments);
    }

    public Disclosure.CreateAnd toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.CreateAnd(COMPANION, this.createArguments);
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LandProperty, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.ByKey toInterface(
        daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty.ByKey(COMPANION, this.contractKey);
    }

    public Disclosure.ByKey toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ByKey(COMPANION, this.contractKey);
    }
  }
}
