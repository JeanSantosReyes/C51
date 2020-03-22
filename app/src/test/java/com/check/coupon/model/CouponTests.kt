package com.check.coupon.model

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CouponSerializationTests {

    companion object {
       private var jsonData = ""
    }
    @Before
    fun setUp()
    {
        jsonData =
            "{\"batch_id\":0,\"offers\":[{\"offer_id\":\"40408\",\"name\":\"Buy 2: Select TRISCUIT Crackers\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/6840/67561_1535141624.jpg\",\"cash_back\":1},{\"offer_id\":\"39271\",\"name\":\"Tide Liquid Detergent\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/4902/56910_1527084051.jpg\",\"cash_back\":1},{\"offer_id\":\"38744\",\"name\":\"Dawn\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/1795/10751_1439567381\",\"cash_back\":0.5},{\"offer_id\":\"41050\",\"name\":\"Dove Shower Foam or Dove Men+Care Foaming Body Wash\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7754/68780_1536591544.jpg\",\"cash_back\":2.5},{\"offer_id\":\"40655\",\"name\":\"Tostitos Hint of Roasted Garlic\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7600/67648_1534338838.jpg\",\"cash_back\":1},{\"offer_id\":\"40433\",\"name\":\"TRISCUIT Organic\",\"image_url\":\"https://checkout51-production.s3-us-west-2.amazonaws.com/1534361237_16814358_ADMIN_UPLOAD67606-list.jpg\",\"cash_back\":1},{\"offer_id\":\"39287\",\"name\":\"Mackie's of Scotland Potato Crisps\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/6923/62734_1526399532.jpg\",\"cash_back\":1},{\"offer_id\":\"39604\",\"name\":\"Sanissimo Oven-Baked Corn Crackers\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7348/66109_1531420737.jpg\",\"cash_back\":1},{\"offer_id\":\"34656\",\"name\":\"Vector Protein Bars\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/4130/38880_1496766889.jpg\",\"cash_back\":1},{\"offer_id\":\"41104\",\"name\":\"Pure Protein Chewy Oat Bars\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/6693/67452_1534514057.jpg\",\"cash_back\":1},{\"offer_id\":\"35990\",\"name\":\"Manitoba Harvest Hemp Hearts\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/5857/54523_1513026815.jpg\",\"cash_back\":1.5},{\"offer_id\":\"40809\",\"name\":\"Hellmann's made with Avocado oil\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7414/67754_1534444028.jpg\",\"cash_back\":1},{\"offer_id\":\"40854\",\"name\":\"Hellmann's Extra Creamy\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7414/68416_1536067855.jpg\",\"cash_back\":1},{\"offer_id\":\"36259\",\"name\":\"Casbah Products\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/6508/59925_1521222040.jpg\",\"cash_back\":1},{\"offer_id\":\"34655\",\"name\":\"Vector Meal Replacement\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/5987/56389_1516908117.jpg\",\"cash_back\":1},{\"offer_id\":\"40204\",\"name\":\"Chosen Foods Vegan Mayo\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7527/67175_1533222675.jpg\",\"cash_back\":3},{\"offer_id\":\"34393\",\"name\":\"Grimm's Naturally Fermented Foods\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/6102/56393_1516639373.jpg\",\"cash_back\":1},{\"offer_id\":\"39939\",\"name\":\"Select Swanson Soup Products\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/5968/66691_1532455333.jpg\",\"cash_back\":0.75},{\"offer_id\":\"39992\",\"name\":\"Buy 3: Campbell's Broth\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7466/66793_1533061144.jpg\",\"cash_back\":2},{\"offer_id\":\"38426\",\"name\":\"Pure Via sweeteners\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/5741/53509_1511302596.jpg\",\"cash_back\":2},{\"offer_id\":\"40789\",\"name\":\"Stubb's BBQ Sauce\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7690/68293_1536024660.jpg\",\"cash_back\":1},{\"offer_id\":\"38447\",\"name\":\"International Collection Oils\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7105/63947_1528312196.jpg\",\"cash_back\":1},{\"offer_id\":\"40200\",\"name\":\"Chosen Foods Avocado Oil Dressings\",\"image_url\":\"https://d3bx4ud3idzsqf.cloudfront.net/public/production/7527/67168_1533221549.jpg\",\"cash_back\":3}]}"
    }
    @Test
    fun generateGsonSerialization() {
          Assert.assertTrue(isValidJsonSerialization(jsonData))
    }

    private fun isValidJsonSerialization(Json: String?): Boolean {
        val gson = Gson()
        return try {
            gson.fromJson(Json, Coupon::class.java)
            val couponObject: Coupon = gson.fromJson(Json, Coupon::class.java)
            return couponObject.offers.size>0
        } catch (ex: JsonSyntaxException) {
            false
        }
    }
}