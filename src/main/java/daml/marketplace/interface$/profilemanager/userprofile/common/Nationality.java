package daml.interface$.profilemanager.userprofile.common;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlEnum;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum Nationality implements DamlEnum<Nationality> {
  AFGHAN,

  ALBANIAN,

  ALGERIAN,

  ANDORRAN,

  ANGOLAN,

  ANTIGUANSANDBARBUDANS,

  ARGENTINEAN,

  ARMENIAN,

  AUSTRALIAN,

  AUSTRIAN,

  AZERBAIJANI,

  BAHAMIAN,

  BAHRAINI,

  BANGLADESHI,

  BARBADIAN,

  BELARUSIAN,

  BELGIAN,

  BELIZEAN,

  BENINESE,

  BHUTANESE,

  BOLIVIAN,

  BOSNIANHERZEGOVINIAN,

  BOTSWANAN,

  BRAZILIAN,

  BRITISH,

  BRUNEIAN,

  BULGARIAN,

  BURKINABE,

  BURMESE,

  BURUNDIAN,

  CAMBODIAN,

  CAMEROONIAN,

  CANADIAN,

  CAPEVERDEAN,

  CENTRALAFRICAN,

  CHADIAN,

  CHILEAN,

  CHINESE,

  COLOMBIAN,

  COMORAN,

  CONGOLESE,

  COSTARICAN,

  CROATIAN,

  CUBAN,

  CYPRIOT,

  CZECH,

  DANISH,

  DJIBOUTI,

  DOMINICAN,

  DUTCH,

  EASTTIMORESE,

  ECUADOREAN,

  EGYPTIAN,

  EMIRIAN,

  EQUATORIALGUINEAN,

  ERITREAN,

  ESTONIAN,

  ETHIOPIAN,

  FIJIAN,

  FILIPINO,

  FINNISH,

  FRENCH,

  GABONESE,

  GAMBIAN,

  GEORGIAN,

  GERMAN,

  GHANAIAN,

  GREEK,

  GRENADIAN,

  GUATEMALAN,

  GUINEAN,

  GUINEABISSAUAN,

  GUYANESE,

  HAITIAN,

  HERZEGOVINIAN,

  HONDURAN,

  HUNGARIAN,

  ICELANDER,

  INDIAN,

  INDONESIAN,

  IRANIAN,

  IRAQI,

  IRISH,

  ISRAELI,

  ITALIAN,

  IVORIAN,

  JAMAICAN,

  JAPANESE,

  JORDANIAN,

  KAZAKHSTANI,

  KENYAN,

  KITTIANANDNEVISIAN,

  KUWAITI,

  KYRGYZ,

  LAOTIAN,

  LATVIAN,

  LEBANESE,

  LIBERIAN,

  LIBYAN,

  LIECHTENSTEINER,

  LITHUANIAN,

  LUXEMBOURGER,

  MACEDONIAN,

  MALAGASY,

  MALAWIAN,

  MALAYSIAN,

  MALDIVAN,

  MALIAN,

  MALTESE,

  MARSHALLESE,

  MAURITANIAN,

  MAURITIAN,

  MEXICAN,

  MICRONESIAN,

  MOLDOVAN,

  MONACAN,

  MONGOLIAN,

  MOROCCAN,

  MOSOTHO,

  MOTSWANA,

  MOZAMBICAN,

  NAMIBIAN,

  NAURUAN,

  NEPALESE,

  NEWZEALANDER,

  NIVANUATU,

  NICARAGUAN,

  NIGERIEN,

  NORTHKOREAN,

  NORTHERNIRISH,

  NORWEGIAN,

  OMANI,

  PAKISTANI,

  PALAUAN,

  PANAMANIAN,

  PAPUANEWGUINEAN,

  PARAGUAYAN,

  PERUVIAN,

  POLISH,

  PORTUGUESE,

  QATARI,

  ROMANIAN,

  RUSSIAN,

  RWANDAN,

  SAINTLUCIAN,

  SALVADORAN,

  SAMOAN,

  SANMARINESE,

  SAOTOMEAN,

  SAUDI,

  SCOTTISH,

  SENEGALESE,

  SERBIAN,

  SEYCHELLOIS,

  SIERRALEONEAN,

  SINGAPOREAN,

  SLOVAKIAN,

  SLOVENIAN,

  SOLOMONISLANDER,

  SOMALI,

  SOUTHAFRICAN,

  SOUTHKOREAN,

  SPANISH,

  SRILANKAN,

  SUDANESE,

  SURINAMER,

  SWAZI,

  SWEDISH,

  SWISS,

  SYRIAN,

  TAIWANESE,

  TAJIK,

  TANZANIAN,

  THAI,

  TOGOLESE,

  TONGAN,

  TRINIDADIANORTOBAGONIAN,

  TUNISIAN,

  TURKISH,

  TUVALUAN,

  UGANDAN,

  UKRAINIAN,

  URUGUAYAN,

  UZBEKISTANI,

  VENEZUELAN,

  VIETNAMESE,

  WELSH,

  YEMENITE,

  ZAMBIAN,

  ZIMBABWEAN;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("Afghan"), new com.daml.ledger.javaapi.data.DamlEnum("Albanian"), new com.daml.ledger.javaapi.data.DamlEnum("Algerian"), new com.daml.ledger.javaapi.data.DamlEnum("Andorran"), new com.daml.ledger.javaapi.data.DamlEnum("Angolan"), new com.daml.ledger.javaapi.data.DamlEnum("AntiguansAndBarbudans"), new com.daml.ledger.javaapi.data.DamlEnum("Argentinean"), new com.daml.ledger.javaapi.data.DamlEnum("Armenian"), new com.daml.ledger.javaapi.data.DamlEnum("Australian"), new com.daml.ledger.javaapi.data.DamlEnum("Austrian"), new com.daml.ledger.javaapi.data.DamlEnum("Azerbaijani"), new com.daml.ledger.javaapi.data.DamlEnum("Bahamian"), new com.daml.ledger.javaapi.data.DamlEnum("Bahraini"), new com.daml.ledger.javaapi.data.DamlEnum("Bangladeshi"), new com.daml.ledger.javaapi.data.DamlEnum("Barbadian"), new com.daml.ledger.javaapi.data.DamlEnum("Belarusian"), new com.daml.ledger.javaapi.data.DamlEnum("Belgian"), new com.daml.ledger.javaapi.data.DamlEnum("Belizean"), new com.daml.ledger.javaapi.data.DamlEnum("Beninese"), new com.daml.ledger.javaapi.data.DamlEnum("Bhutanese"), new com.daml.ledger.javaapi.data.DamlEnum("Bolivian"), new com.daml.ledger.javaapi.data.DamlEnum("BosnianHerzegovinian"), new com.daml.ledger.javaapi.data.DamlEnum("Botswanan"), new com.daml.ledger.javaapi.data.DamlEnum("Brazilian"), new com.daml.ledger.javaapi.data.DamlEnum("British"), new com.daml.ledger.javaapi.data.DamlEnum("Bruneian"), new com.daml.ledger.javaapi.data.DamlEnum("Bulgarian"), new com.daml.ledger.javaapi.data.DamlEnum("Burkinabe"), new com.daml.ledger.javaapi.data.DamlEnum("Burmese"), new com.daml.ledger.javaapi.data.DamlEnum("Burundian"), new com.daml.ledger.javaapi.data.DamlEnum("Cambodian"), new com.daml.ledger.javaapi.data.DamlEnum("Cameroonian"), new com.daml.ledger.javaapi.data.DamlEnum("Canadian"), new com.daml.ledger.javaapi.data.DamlEnum("CapeVerdean"), new com.daml.ledger.javaapi.data.DamlEnum("CentralAfrican"), new com.daml.ledger.javaapi.data.DamlEnum("Chadian"), new com.daml.ledger.javaapi.data.DamlEnum("Chilean"), new com.daml.ledger.javaapi.data.DamlEnum("Chinese"), new com.daml.ledger.javaapi.data.DamlEnum("Colombian"), new com.daml.ledger.javaapi.data.DamlEnum("Comoran"), new com.daml.ledger.javaapi.data.DamlEnum("Congolese"), new com.daml.ledger.javaapi.data.DamlEnum("CostaRican"), new com.daml.ledger.javaapi.data.DamlEnum("Croatian"), new com.daml.ledger.javaapi.data.DamlEnum("Cuban"), new com.daml.ledger.javaapi.data.DamlEnum("Cypriot"), new com.daml.ledger.javaapi.data.DamlEnum("Czech"), new com.daml.ledger.javaapi.data.DamlEnum("Danish"), new com.daml.ledger.javaapi.data.DamlEnum("Djibouti"), new com.daml.ledger.javaapi.data.DamlEnum("Dominican"), new com.daml.ledger.javaapi.data.DamlEnum("Dutch"), new com.daml.ledger.javaapi.data.DamlEnum("EastTimorese"), new com.daml.ledger.javaapi.data.DamlEnum("Ecuadorean"), new com.daml.ledger.javaapi.data.DamlEnum("Egyptian"), new com.daml.ledger.javaapi.data.DamlEnum("Emirian"), new com.daml.ledger.javaapi.data.DamlEnum("EquatorialGuinean"), new com.daml.ledger.javaapi.data.DamlEnum("Eritrean"), new com.daml.ledger.javaapi.data.DamlEnum("Estonian"), new com.daml.ledger.javaapi.data.DamlEnum("Ethiopian"), new com.daml.ledger.javaapi.data.DamlEnum("Fijian"), new com.daml.ledger.javaapi.data.DamlEnum("Filipino"), new com.daml.ledger.javaapi.data.DamlEnum("Finnish"), new com.daml.ledger.javaapi.data.DamlEnum("French"), new com.daml.ledger.javaapi.data.DamlEnum("Gabonese"), new com.daml.ledger.javaapi.data.DamlEnum("Gambian"), new com.daml.ledger.javaapi.data.DamlEnum("Georgian"), new com.daml.ledger.javaapi.data.DamlEnum("German"), new com.daml.ledger.javaapi.data.DamlEnum("Ghanaian"), new com.daml.ledger.javaapi.data.DamlEnum("Greek"), new com.daml.ledger.javaapi.data.DamlEnum("Grenadian"), new com.daml.ledger.javaapi.data.DamlEnum("Guatemalan"), new com.daml.ledger.javaapi.data.DamlEnum("Guinean"), new com.daml.ledger.javaapi.data.DamlEnum("GuineaBissauan"), new com.daml.ledger.javaapi.data.DamlEnum("Guyanese"), new com.daml.ledger.javaapi.data.DamlEnum("Haitian"), new com.daml.ledger.javaapi.data.DamlEnum("Herzegovinian"), new com.daml.ledger.javaapi.data.DamlEnum("Honduran"), new com.daml.ledger.javaapi.data.DamlEnum("Hungarian"), new com.daml.ledger.javaapi.data.DamlEnum("Icelander"), new com.daml.ledger.javaapi.data.DamlEnum("Indian"), new com.daml.ledger.javaapi.data.DamlEnum("Indonesian"), new com.daml.ledger.javaapi.data.DamlEnum("Iranian"), new com.daml.ledger.javaapi.data.DamlEnum("Iraqi"), new com.daml.ledger.javaapi.data.DamlEnum("Irish"), new com.daml.ledger.javaapi.data.DamlEnum("Israeli"), new com.daml.ledger.javaapi.data.DamlEnum("Italian"), new com.daml.ledger.javaapi.data.DamlEnum("Ivorian"), new com.daml.ledger.javaapi.data.DamlEnum("Jamaican"), new com.daml.ledger.javaapi.data.DamlEnum("Japanese"), new com.daml.ledger.javaapi.data.DamlEnum("Jordanian"), new com.daml.ledger.javaapi.data.DamlEnum("Kazakhstani"), new com.daml.ledger.javaapi.data.DamlEnum("Kenyan"), new com.daml.ledger.javaapi.data.DamlEnum("KittianAndNevisian"), new com.daml.ledger.javaapi.data.DamlEnum("Kuwaiti"), new com.daml.ledger.javaapi.data.DamlEnum("Kyrgyz"), new com.daml.ledger.javaapi.data.DamlEnum("Laotian"), new com.daml.ledger.javaapi.data.DamlEnum("Latvian"), new com.daml.ledger.javaapi.data.DamlEnum("Lebanese"), new com.daml.ledger.javaapi.data.DamlEnum("Liberian"), new com.daml.ledger.javaapi.data.DamlEnum("Libyan"), new com.daml.ledger.javaapi.data.DamlEnum("Liechtensteiner"), new com.daml.ledger.javaapi.data.DamlEnum("Lithuanian"), new com.daml.ledger.javaapi.data.DamlEnum("Luxembourger"), new com.daml.ledger.javaapi.data.DamlEnum("Macedonian"), new com.daml.ledger.javaapi.data.DamlEnum("Malagasy"), new com.daml.ledger.javaapi.data.DamlEnum("Malawian"), new com.daml.ledger.javaapi.data.DamlEnum("Malaysian"), new com.daml.ledger.javaapi.data.DamlEnum("Maldivan"), new com.daml.ledger.javaapi.data.DamlEnum("Malian"), new com.daml.ledger.javaapi.data.DamlEnum("Maltese"), new com.daml.ledger.javaapi.data.DamlEnum("Marshallese"), new com.daml.ledger.javaapi.data.DamlEnum("Mauritanian"), new com.daml.ledger.javaapi.data.DamlEnum("Mauritian"), new com.daml.ledger.javaapi.data.DamlEnum("Mexican"), new com.daml.ledger.javaapi.data.DamlEnum("Micronesian"), new com.daml.ledger.javaapi.data.DamlEnum("Moldovan"), new com.daml.ledger.javaapi.data.DamlEnum("Monacan"), new com.daml.ledger.javaapi.data.DamlEnum("Mongolian"), new com.daml.ledger.javaapi.data.DamlEnum("Moroccan"), new com.daml.ledger.javaapi.data.DamlEnum("Mosotho"), new com.daml.ledger.javaapi.data.DamlEnum("Motswana"), new com.daml.ledger.javaapi.data.DamlEnum("Mozambican"), new com.daml.ledger.javaapi.data.DamlEnum("Namibian"), new com.daml.ledger.javaapi.data.DamlEnum("Nauruan"), new com.daml.ledger.javaapi.data.DamlEnum("Nepalese"), new com.daml.ledger.javaapi.data.DamlEnum("NewZealander"), new com.daml.ledger.javaapi.data.DamlEnum("NiVanuatu"), new com.daml.ledger.javaapi.data.DamlEnum("Nicaraguan"), new com.daml.ledger.javaapi.data.DamlEnum("Nigerien"), new com.daml.ledger.javaapi.data.DamlEnum("NorthKorean"), new com.daml.ledger.javaapi.data.DamlEnum("NorthernIrish"), new com.daml.ledger.javaapi.data.DamlEnum("Norwegian"), new com.daml.ledger.javaapi.data.DamlEnum("Omani"), new com.daml.ledger.javaapi.data.DamlEnum("Pakistani"), new com.daml.ledger.javaapi.data.DamlEnum("Palauan"), new com.daml.ledger.javaapi.data.DamlEnum("Panamanian"), new com.daml.ledger.javaapi.data.DamlEnum("PapuaNewGuinean"), new com.daml.ledger.javaapi.data.DamlEnum("Paraguayan"), new com.daml.ledger.javaapi.data.DamlEnum("Peruvian"), new com.daml.ledger.javaapi.data.DamlEnum("Polish"), new com.daml.ledger.javaapi.data.DamlEnum("Portuguese"), new com.daml.ledger.javaapi.data.DamlEnum("Qatari"), new com.daml.ledger.javaapi.data.DamlEnum("Romanian"), new com.daml.ledger.javaapi.data.DamlEnum("Russian"), new com.daml.ledger.javaapi.data.DamlEnum("Rwandan"), new com.daml.ledger.javaapi.data.DamlEnum("SaintLucian"), new com.daml.ledger.javaapi.data.DamlEnum("Salvadoran"), new com.daml.ledger.javaapi.data.DamlEnum("Samoan"), new com.daml.ledger.javaapi.data.DamlEnum("SanMarinese"), new com.daml.ledger.javaapi.data.DamlEnum("SaoTomean"), new com.daml.ledger.javaapi.data.DamlEnum("Saudi"), new com.daml.ledger.javaapi.data.DamlEnum("Scottish"), new com.daml.ledger.javaapi.data.DamlEnum("Senegalese"), new com.daml.ledger.javaapi.data.DamlEnum("Serbian"), new com.daml.ledger.javaapi.data.DamlEnum("Seychellois"), new com.daml.ledger.javaapi.data.DamlEnum("SierraLeonean"), new com.daml.ledger.javaapi.data.DamlEnum("Singaporean"), new com.daml.ledger.javaapi.data.DamlEnum("Slovakian"), new com.daml.ledger.javaapi.data.DamlEnum("Slovenian"), new com.daml.ledger.javaapi.data.DamlEnum("SolomonIslander"), new com.daml.ledger.javaapi.data.DamlEnum("Somali"), new com.daml.ledger.javaapi.data.DamlEnum("SouthAfrican"), new com.daml.ledger.javaapi.data.DamlEnum("SouthKorean"), new com.daml.ledger.javaapi.data.DamlEnum("Spanish"), new com.daml.ledger.javaapi.data.DamlEnum("SriLankan"), new com.daml.ledger.javaapi.data.DamlEnum("Sudanese"), new com.daml.ledger.javaapi.data.DamlEnum("Surinamer"), new com.daml.ledger.javaapi.data.DamlEnum("Swazi"), new com.daml.ledger.javaapi.data.DamlEnum("Swedish"), new com.daml.ledger.javaapi.data.DamlEnum("Swiss"), new com.daml.ledger.javaapi.data.DamlEnum("Syrian"), new com.daml.ledger.javaapi.data.DamlEnum("Taiwanese"), new com.daml.ledger.javaapi.data.DamlEnum("Tajik"), new com.daml.ledger.javaapi.data.DamlEnum("Tanzanian"), new com.daml.ledger.javaapi.data.DamlEnum("Thai"), new com.daml.ledger.javaapi.data.DamlEnum("Togolese"), new com.daml.ledger.javaapi.data.DamlEnum("Tongan"), new com.daml.ledger.javaapi.data.DamlEnum("TrinidadianOrTobagonian"), new com.daml.ledger.javaapi.data.DamlEnum("Tunisian"), new com.daml.ledger.javaapi.data.DamlEnum("Turkish"), new com.daml.ledger.javaapi.data.DamlEnum("Tuvaluan"), new com.daml.ledger.javaapi.data.DamlEnum("Ugandan"), new com.daml.ledger.javaapi.data.DamlEnum("Ukrainian"), new com.daml.ledger.javaapi.data.DamlEnum("Uruguayan"), new com.daml.ledger.javaapi.data.DamlEnum("Uzbekistani"), new com.daml.ledger.javaapi.data.DamlEnum("Venezuelan"), new com.daml.ledger.javaapi.data.DamlEnum("Vietnamese"), new com.daml.ledger.javaapi.data.DamlEnum("Welsh"), new com.daml.ledger.javaapi.data.DamlEnum("Yemenite"), new com.daml.ledger.javaapi.data.DamlEnum("Zambian"), new com.daml.ledger.javaapi.data.DamlEnum("Zimbabwean")};

  private static final Map<String, Nationality> __enums$ = __buildEnumsMap$();

  private static final Map<String, Nationality> __buildEnumsMap$() {
    Map<String, Nationality> m = new HashMap<String, Nationality>();
    m.put("Afghan", AFGHAN);
    m.put("Albanian", ALBANIAN);
    m.put("Algerian", ALGERIAN);
    m.put("Andorran", ANDORRAN);
    m.put("Angolan", ANGOLAN);
    m.put("AntiguansAndBarbudans", ANTIGUANSANDBARBUDANS);
    m.put("Argentinean", ARGENTINEAN);
    m.put("Armenian", ARMENIAN);
    m.put("Australian", AUSTRALIAN);
    m.put("Austrian", AUSTRIAN);
    m.put("Azerbaijani", AZERBAIJANI);
    m.put("Bahamian", BAHAMIAN);
    m.put("Bahraini", BAHRAINI);
    m.put("Bangladeshi", BANGLADESHI);
    m.put("Barbadian", BARBADIAN);
    m.put("Belarusian", BELARUSIAN);
    m.put("Belgian", BELGIAN);
    m.put("Belizean", BELIZEAN);
    m.put("Beninese", BENINESE);
    m.put("Bhutanese", BHUTANESE);
    m.put("Bolivian", BOLIVIAN);
    m.put("BosnianHerzegovinian", BOSNIANHERZEGOVINIAN);
    m.put("Botswanan", BOTSWANAN);
    m.put("Brazilian", BRAZILIAN);
    m.put("British", BRITISH);
    m.put("Bruneian", BRUNEIAN);
    m.put("Bulgarian", BULGARIAN);
    m.put("Burkinabe", BURKINABE);
    m.put("Burmese", BURMESE);
    m.put("Burundian", BURUNDIAN);
    m.put("Cambodian", CAMBODIAN);
    m.put("Cameroonian", CAMEROONIAN);
    m.put("Canadian", CANADIAN);
    m.put("CapeVerdean", CAPEVERDEAN);
    m.put("CentralAfrican", CENTRALAFRICAN);
    m.put("Chadian", CHADIAN);
    m.put("Chilean", CHILEAN);
    m.put("Chinese", CHINESE);
    m.put("Colombian", COLOMBIAN);
    m.put("Comoran", COMORAN);
    m.put("Congolese", CONGOLESE);
    m.put("CostaRican", COSTARICAN);
    m.put("Croatian", CROATIAN);
    m.put("Cuban", CUBAN);
    m.put("Cypriot", CYPRIOT);
    m.put("Czech", CZECH);
    m.put("Danish", DANISH);
    m.put("Djibouti", DJIBOUTI);
    m.put("Dominican", DOMINICAN);
    m.put("Dutch", DUTCH);
    m.put("EastTimorese", EASTTIMORESE);
    m.put("Ecuadorean", ECUADOREAN);
    m.put("Egyptian", EGYPTIAN);
    m.put("Emirian", EMIRIAN);
    m.put("EquatorialGuinean", EQUATORIALGUINEAN);
    m.put("Eritrean", ERITREAN);
    m.put("Estonian", ESTONIAN);
    m.put("Ethiopian", ETHIOPIAN);
    m.put("Fijian", FIJIAN);
    m.put("Filipino", FILIPINO);
    m.put("Finnish", FINNISH);
    m.put("French", FRENCH);
    m.put("Gabonese", GABONESE);
    m.put("Gambian", GAMBIAN);
    m.put("Georgian", GEORGIAN);
    m.put("German", GERMAN);
    m.put("Ghanaian", GHANAIAN);
    m.put("Greek", GREEK);
    m.put("Grenadian", GRENADIAN);
    m.put("Guatemalan", GUATEMALAN);
    m.put("Guinean", GUINEAN);
    m.put("GuineaBissauan", GUINEABISSAUAN);
    m.put("Guyanese", GUYANESE);
    m.put("Haitian", HAITIAN);
    m.put("Herzegovinian", HERZEGOVINIAN);
    m.put("Honduran", HONDURAN);
    m.put("Hungarian", HUNGARIAN);
    m.put("Icelander", ICELANDER);
    m.put("Indian", INDIAN);
    m.put("Indonesian", INDONESIAN);
    m.put("Iranian", IRANIAN);
    m.put("Iraqi", IRAQI);
    m.put("Irish", IRISH);
    m.put("Israeli", ISRAELI);
    m.put("Italian", ITALIAN);
    m.put("Ivorian", IVORIAN);
    m.put("Jamaican", JAMAICAN);
    m.put("Japanese", JAPANESE);
    m.put("Jordanian", JORDANIAN);
    m.put("Kazakhstani", KAZAKHSTANI);
    m.put("Kenyan", KENYAN);
    m.put("KittianAndNevisian", KITTIANANDNEVISIAN);
    m.put("Kuwaiti", KUWAITI);
    m.put("Kyrgyz", KYRGYZ);
    m.put("Laotian", LAOTIAN);
    m.put("Latvian", LATVIAN);
    m.put("Lebanese", LEBANESE);
    m.put("Liberian", LIBERIAN);
    m.put("Libyan", LIBYAN);
    m.put("Liechtensteiner", LIECHTENSTEINER);
    m.put("Lithuanian", LITHUANIAN);
    m.put("Luxembourger", LUXEMBOURGER);
    m.put("Macedonian", MACEDONIAN);
    m.put("Malagasy", MALAGASY);
    m.put("Malawian", MALAWIAN);
    m.put("Malaysian", MALAYSIAN);
    m.put("Maldivan", MALDIVAN);
    m.put("Malian", MALIAN);
    m.put("Maltese", MALTESE);
    m.put("Marshallese", MARSHALLESE);
    m.put("Mauritanian", MAURITANIAN);
    m.put("Mauritian", MAURITIAN);
    m.put("Mexican", MEXICAN);
    m.put("Micronesian", MICRONESIAN);
    m.put("Moldovan", MOLDOVAN);
    m.put("Monacan", MONACAN);
    m.put("Mongolian", MONGOLIAN);
    m.put("Moroccan", MOROCCAN);
    m.put("Mosotho", MOSOTHO);
    m.put("Motswana", MOTSWANA);
    m.put("Mozambican", MOZAMBICAN);
    m.put("Namibian", NAMIBIAN);
    m.put("Nauruan", NAURUAN);
    m.put("Nepalese", NEPALESE);
    m.put("NewZealander", NEWZEALANDER);
    m.put("NiVanuatu", NIVANUATU);
    m.put("Nicaraguan", NICARAGUAN);
    m.put("Nigerien", NIGERIEN);
    m.put("NorthKorean", NORTHKOREAN);
    m.put("NorthernIrish", NORTHERNIRISH);
    m.put("Norwegian", NORWEGIAN);
    m.put("Omani", OMANI);
    m.put("Pakistani", PAKISTANI);
    m.put("Palauan", PALAUAN);
    m.put("Panamanian", PANAMANIAN);
    m.put("PapuaNewGuinean", PAPUANEWGUINEAN);
    m.put("Paraguayan", PARAGUAYAN);
    m.put("Peruvian", PERUVIAN);
    m.put("Polish", POLISH);
    m.put("Portuguese", PORTUGUESE);
    m.put("Qatari", QATARI);
    m.put("Romanian", ROMANIAN);
    m.put("Russian", RUSSIAN);
    m.put("Rwandan", RWANDAN);
    m.put("SaintLucian", SAINTLUCIAN);
    m.put("Salvadoran", SALVADORAN);
    m.put("Samoan", SAMOAN);
    m.put("SanMarinese", SANMARINESE);
    m.put("SaoTomean", SAOTOMEAN);
    m.put("Saudi", SAUDI);
    m.put("Scottish", SCOTTISH);
    m.put("Senegalese", SENEGALESE);
    m.put("Serbian", SERBIAN);
    m.put("Seychellois", SEYCHELLOIS);
    m.put("SierraLeonean", SIERRALEONEAN);
    m.put("Singaporean", SINGAPOREAN);
    m.put("Slovakian", SLOVAKIAN);
    m.put("Slovenian", SLOVENIAN);
    m.put("SolomonIslander", SOLOMONISLANDER);
    m.put("Somali", SOMALI);
    m.put("SouthAfrican", SOUTHAFRICAN);
    m.put("SouthKorean", SOUTHKOREAN);
    m.put("Spanish", SPANISH);
    m.put("SriLankan", SRILANKAN);
    m.put("Sudanese", SUDANESE);
    m.put("Surinamer", SURINAMER);
    m.put("Swazi", SWAZI);
    m.put("Swedish", SWEDISH);
    m.put("Swiss", SWISS);
    m.put("Syrian", SYRIAN);
    m.put("Taiwanese", TAIWANESE);
    m.put("Tajik", TAJIK);
    m.put("Tanzanian", TANZANIAN);
    m.put("Thai", THAI);
    m.put("Togolese", TOGOLESE);
    m.put("Tongan", TONGAN);
    m.put("TrinidadianOrTobagonian", TRINIDADIANORTOBAGONIAN);
    m.put("Tunisian", TUNISIAN);
    m.put("Turkish", TURKISH);
    m.put("Tuvaluan", TUVALUAN);
    m.put("Ugandan", UGANDAN);
    m.put("Ukrainian", UKRAINIAN);
    m.put("Uruguayan", URUGUAYAN);
    m.put("Uzbekistani", UZBEKISTANI);
    m.put("Venezuelan", VENEZUELAN);
    m.put("Vietnamese", VIETNAMESE);
    m.put("Welsh", WELSH);
    m.put("Yemenite", YEMENITE);
    m.put("Zambian", ZAMBIAN);
    m.put("Zimbabwean", ZIMBABWEAN);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final Nationality fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<Nationality> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Nationality")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Nationality constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<Nationality> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static Nationality fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((Nationality e$) -> e$.getConstructor()).apply(this);
  }
}
