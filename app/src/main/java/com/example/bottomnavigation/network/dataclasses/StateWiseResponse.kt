package com.example.bottomnavigation.network.dataclasses


import com.google.gson.annotations.SerializedName

data class StateWiseResponse(
    @SerializedName("Andhra Pradesh")
    val andhraPradesh: AndhraPradesh,
    @SerializedName("Bihar")
    val bihar: Bihar,
    @SerializedName("Chandigarh")
    val chandigarh: Chandigarh,
    @SerializedName("Chhattisgarh")
    val chhattisgarh: Chhattisgarh,
    @SerializedName("Delhi")
    val delhi: Delhi,
    @SerializedName("Goa")
    val goa: Goa,
    @SerializedName("Gujarat")
    val gujarat: Gujarat,
    @SerializedName("Haryana")
    val haryana: Haryana,
    @SerializedName("Himachal Pradesh")
    val himachalPradesh: HimachalPradesh,
    @SerializedName("Jammu and Kashmir")
    val jammuAndKashmir: JammuAndKashmir,
    @SerializedName("Karnataka")
    val karnataka: Karnataka,
    @SerializedName("Kerala")
    val kerala: Kerala,
    @SerializedName("Ladakh")
    val ladakh: Ladakh,
    @SerializedName("Madhya Pradesh")
    val madhyaPradesh: MadhyaPradesh,
    @SerializedName("Maharashtra")
    val maharashtra: Maharashtra,
    @SerializedName("Manipur")
    val manipur: Manipur,
    @SerializedName("Mizoram")
    val mizoram: Mizoram,
    @SerializedName("Odisha")
    val odisha: Odisha,
    @SerializedName("Puducherry")
    val puducherry: Puducherry,
    @SerializedName("Punjab")
    val punjab: Punjab,
    @SerializedName("Rajasthan")
    val rajasthan: Rajasthan,
    @SerializedName("Tamil Nadu")
    val tamilNadu: TamilNadu,
    @SerializedName("Telangana")
    val telangana: Telangana,
    @SerializedName("Unknown")
    val unknown: Unknown,
    @SerializedName("Uttar Pradesh")
    val uttarPradesh: UttarPradesh,
    @SerializedName("Uttarakhand")
    val uttarakhand: Uttarakhand,
    @SerializedName("West Bengal")
    val westBengal: WestBengal
) {
    data class AndhraPradesh(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Chitoor")
            val chitoor: Chitoor,
            @SerializedName("East Godavari")
            val eastGodavari: EastGodavari,
            @SerializedName("Guntur")
            val guntur: Guntur,
            @SerializedName("Krishna")
            val krishna: Krishna,
            @SerializedName("Prakasam")
            val prakasam: Prakasam,
            @SerializedName("S.P.S. Nellore")
            val sPSNellore: SPSNellore,
            @SerializedName("Vijayawada")
            val vijayawada: Vijayawada,
            @SerializedName("Visakhapatnam")
            val visakhapatnam: Visakhapatnam,
            @SerializedName("Vishakhapatnam")
            val vishakhapatnam: Vishakhapatnam
        ) {
            data class Chitoor(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class EastGodavari(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Guntur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Krishna(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Prakasam(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class SPSNellore(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Vijayawada(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Visakhapatnam(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Vishakhapatnam(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Bihar(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Munger")
            val munger: Munger,
            @SerializedName("Patna")
            val patna: Patna
        ) {
            data class Munger(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Patna(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Chandigarh(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Chandigarh")
            val chandigarh: Chandigarh
        ) {
            data class Chandigarh(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Chhattisgarh(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Delhi(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Delhi")
            val delhi: Delhi,
            @SerializedName("East Delhi")
            val eastDelhi: EastDelhi,
            @SerializedName("South West Delhi")
            val southWestDelhi: SouthWestDelhi,
            @SerializedName("Unknown")
            val unknown: Unknown,
            @SerializedName("West Delhi")
            val westDelhi: WestDelhi
        ) {
            data class Delhi(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class EastDelhi(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class SouthWestDelhi(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class WestDelhi(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Goa(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Goa")
            val goa: Goa
        ) {
            data class Goa(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Gujarat(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Ahmedabad")
            val ahmedabad: Ahmedabad,
            @SerializedName("Gandhinagar")
            val gandhinagar: Gandhinagar,
            @SerializedName("Kutch")
            val kutch: Kutch,
            @SerializedName("Rajkot")
            val rajkot: Rajkot,
            @SerializedName("Surat")
            val surat: Surat,
            @SerializedName("Unknown")
            val unknown: Unknown,
            @SerializedName("Vadodara")
            val vadodara: Vadodara
        ) {
            data class Ahmedabad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Gandhinagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kutch(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Rajkot(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Surat(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Vadodara(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Haryana(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Faridabad")
            val faridabad: Faridabad,
            @SerializedName("Gurugram")
            val gurugram: Gurugram,
            @SerializedName("Palwal")
            val palwal: Palwal,
            @SerializedName("Panchkula")
            val panchkula: Panchkula,
            @SerializedName("Panipat")
            val panipat: Panipat,
            @SerializedName("Sonepat")
            val sonepat: Sonepat
        ) {
            data class Faridabad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Gurugram(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Palwal(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Panchkula(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Panipat(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Sonepat(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class HimachalPradesh(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Kangra")
            val kangra: Kangra
        ) {
            data class Kangra(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class JammuAndKashmir(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Bandipora")
            val bandipora: Bandipora,
            @SerializedName("Jammu")
            val jammu: Jammu,
            @SerializedName("Srinagar")
            val srinagar: Srinagar,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Bandipora(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Jammu(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Srinagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Karnataka(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Bengaluru")
            val bengaluru: Bengaluru,
            @SerializedName("Chikkaballapura")
            val chikkaballapura: Chikkaballapura,
            @SerializedName("Chitradurga")
            val chitradurga: Chitradurga,
            @SerializedName("Dakshina Kannada")
            val dakshinaKannada: DakshinaKannada,
            @SerializedName("Dharwad")
            val dharwad: Dharwad,
            @SerializedName("Kalaburagi")
            val kalaburagi: Kalaburagi,
            @SerializedName("Kasaragod")
            val kasaragod: Kasaragod,
            @SerializedName("Kodagu")
            val kodagu: Kodagu,
            @SerializedName("Mysuru")
            val mysuru: Mysuru,
            @SerializedName("Udupi")
            val udupi: Udupi,
            @SerializedName("Uttara Kannada")
            val uttaraKannada: UttaraKannada
        ) {
            data class Bengaluru(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Chikkaballapura(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Chitradurga(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class DakshinaKannada(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Dharwad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kalaburagi(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kasaragod(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kodagu(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Mysuru(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Udupi(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class UttaraKannada(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Kerala(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Alappuzha")
            val alappuzha: Alappuzha,
            @SerializedName("Ernakulam")
            val ernakulam: Ernakulam,
            @SerializedName("Idukki")
            val idukki: Idukki,
            @SerializedName("Kannur")
            val kannur: Kannur,
            @SerializedName("Kasaragod")
            val kasaragod: Kasaragod,
            @SerializedName("Kasargod")
            val kasargod: Kasargod,
            @SerializedName("Kottayam")
            val kottayam: Kottayam,
            @SerializedName("Kozhikode")
            val kozhikode: Kozhikode,
            @SerializedName("Malappuram")
            val malappuram: Malappuram,
            @SerializedName("Palakkad")
            val palakkad: Palakkad,
            @SerializedName("Pathanamthitta")
            val pathanamthitta: Pathanamthitta,
            @SerializedName("Thiruvananthapuram")
            val thiruvananthapuram: Thiruvananthapuram,
            @SerializedName("Thrissur")
            val thrissur: Thrissur,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Alappuzha(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Ernakulam(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Idukki(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kannur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kasaragod(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kasargod(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kottayam(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kozhikode(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Malappuram(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Palakkad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Pathanamthitta(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Thiruvananthapuram(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Thrissur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Ladakh(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Kargil")
            val kargil: Kargil,
            @SerializedName("Leh")
            val leh: Leh
        ) {
            data class Kargil(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Leh(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class MadhyaPradesh(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Bhopal")
            val bhopal: Bhopal,
            @SerializedName("Gwalior")
            val gwalior: Gwalior,
            @SerializedName("Jabalpur")
            val jabalpur: Jabalpur,
            @SerializedName("Shivpuri")
            val shivpuri: Shivpuri,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Bhopal(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Gwalior(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Jabalpur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Shivpuri(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Maharashtra(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Ahmadnagar")
            val ahmadnagar: Ahmadnagar,
            @SerializedName("Aurangabad")
            val aurangabad: Aurangabad,
            @SerializedName("Mumbai")
            val mumbai: Mumbai,
            @SerializedName("Nagpur")
            val nagpur: Nagpur,
            @SerializedName("Pune")
            val pune: Pune,
            @SerializedName("Ratnagiri")
            val ratnagiri: Ratnagiri,
            @SerializedName("Satara")
            val satara: Satara,
            @SerializedName("Thane")
            val thane: Thane,
            @SerializedName("Unknown")
            val unknown: Unknown,
            @SerializedName("Yavatmal")
            val yavatmal: Yavatmal
        ) {
            data class Ahmadnagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Aurangabad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Mumbai(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Nagpur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Pune(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Ratnagiri(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Satara(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Thane(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Yavatmal(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Manipur(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Imphal West")
            val imphalWest: ImphalWest
        ) {
            data class ImphalWest(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Mizoram(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Aizawl")
            val aizawl: Aizawl
        ) {
            data class Aizawl(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Odisha(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Puducherry(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Mahe")
            val mahe: Mahe
        ) {
            data class Mahe(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Punjab(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Amritsar")
            val amritsar: Amritsar,
            @SerializedName("Hoshiarpur")
            val hoshiarpur: Hoshiarpur,
            @SerializedName("Jalandhar")
            val jalandhar: Jalandhar,
            @SerializedName("Ludhiana")
            val ludhiana: Ludhiana,
            @SerializedName("Sahibzada Ajit Singh Nagar")
            val sahibzadaAjitSinghNagar: SahibzadaAjitSinghNagar,
            @SerializedName("Shaheed Bhagat Singh Nagar")
            val shaheedBhagatSinghNagar: ShaheedBhagatSinghNagar,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Amritsar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Hoshiarpur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Jalandhar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Ludhiana(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class SahibzadaAjitSinghNagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class ShaheedBhagatSinghNagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Rajasthan(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Bhilwara")
            val bhilwara: Bhilwara,
            @SerializedName("Jaipur")
            val jaipur: Jaipur,
            @SerializedName("Jhunjhunu")
            val jhunjhunu: Jhunjhunu,
            @SerializedName("Jodhpur")
            val jodhpur: Jodhpur,
            @SerializedName("Pratapgarh ")
            val pratapgarh: Pratapgarh,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Bhilwara(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Jaipur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Jhunjhunu(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Jodhpur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Pratapgarh(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class TamilNadu(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Chennai")
            val chennai: Chennai,
            @SerializedName("Coimbatore")
            val coimbatore: Coimbatore,
            @SerializedName("Erode")
            val erode: Erode,
            @SerializedName("Madurai")
            val madurai: Madurai,
            @SerializedName("Salem")
            val salem: Salem,
            @SerializedName("Tiruneveli")
            val tiruneveli: Tiruneveli,
            @SerializedName("Tiruppur")
            val tiruppur: Tiruppur,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Chennai(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Coimbatore(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Erode(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Madurai(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Salem(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Tiruneveli(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Tiruppur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Telangana(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Bhadradri Kothagudem")
            val bhadradriKothagudem: BhadradriKothagudem,
            @SerializedName("Hyderabad")
            val hyderabad: Hyderabad,
            @SerializedName("Karimnagar")
            val karimnagar: Karimnagar,
            @SerializedName("Ranga Reddy")
            val rangaReddy: RangaReddy,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class BhadradriKothagudem(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Hyderabad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Karimnagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class RangaReddy(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Unknown(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class UttarPradesh(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Agra")
            val agra: Agra,
            @SerializedName("Gautam Buddh Nagar")
            val gautamBuddhNagar: GautamBuddhNagar,
            @SerializedName("Gautam Buddha Nagar")
            val gautamBuddhaNagar: GautamBuddhaNagar,
            @SerializedName("Ghaziabad")
            val ghaziabad: Ghaziabad,
            @SerializedName("Jaunpur")
            val jaunpur: Jaunpur,
            @SerializedName("Kanpur")
            val kanpur: Kanpur,
            @SerializedName("Lucknow")
            val lucknow: Lucknow,
            @SerializedName("Moradabad")
            val moradabad: Moradabad,
            @SerializedName("Pilibhit")
            val pilibhit: Pilibhit,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Agra(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class GautamBuddhNagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class GautamBuddhaNagar(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Ghaziabad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Jaunpur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Kanpur(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Lucknow(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Moradabad(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Pilibhit(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class Uttarakhand(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Pauri")
            val pauri: Pauri,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Pauri(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }

    data class WestBengal(
        @SerializedName("districtData")
        val districtData: DistrictData
    ) {
        data class DistrictData(
            @SerializedName("Kolkata")
            val kolkata: Kolkata,
            @SerializedName("North 24 Parganas")
            val north24Parganas: North24Parganas,
            @SerializedName("North Kolkata")
            val northKolkata: NorthKolkata,
            @SerializedName("Unknown")
            val unknown: Unknown
        ) {
            data class Kolkata(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class North24Parganas(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class NorthKolkata(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )

            data class Unknown(
                @SerializedName("active")
                val active: Int,
                @SerializedName("confirmed")
                val confirmed: Int,
                @SerializedName("deaths")
                val deaths: Int,
                @SerializedName("lastupdatedtime")
                val lastupdatedtime: String,
                @SerializedName("recovered")
                val recovered: Int
            )
        }
    }
}