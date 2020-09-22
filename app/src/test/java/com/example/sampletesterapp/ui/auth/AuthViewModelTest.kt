package com.example.sampletesterapp.ui.auth

import com.example.sampletesterapp.data.network.MyApi
import okhttp3.ResponseBody
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

/**
 *
 * Junit Testing TestCase for apicalling
 * Please make yourself familiar with the basics of Junit Testing
 * @Before,@After,@Test,@Mock,@RunWith annotation
 *
 * Sample Mock Usage
 * @Mock
 * val loginModel: LoginModel
 *
 * @Before
 * Executed before each test.
 * It is used to prepare the test environment
 * (e.g., read input data, initialize the class).
 * @Before
 * fun initBefore(){}
 *
 * @After
 * Executed after each test.
 * It is used to cleanup the test environment
 * (e.g., delete temporary data, restore defaults).
 * It can also save memory by cleaning up expensive memory structures.
 * @After
 * fun initAfter(){}
 *
 * @BeforeClass
 * Executed once, before the start of all tests.
 * It is used to perform time intensive activities,
 * for example, to connect to a database.
 * Methods marked with this annotation need to be defined as static to work with JUnit.
 * @BeforeClass
 * fun initBeforeClass(){}
 *
 * @AfterClass
 * Executed once, after all tests have been finished.
 * It is used to perform clean-up activities, for example,
 * to disconnect from a database. Methods annotated with this annotation need
 * to be defined as static to work with JUnit.
 * @AfterClass
 * fun initAfterClass(){}
 *
 * @Ignore
 * Marks that the test should be disabled.
 * This is useful when the underlying code has been changed
 * and the test case has not yet been adapted. Or if the execution time
 * of this test is too long to be included. It is best practice to provide
 * the optional description, why the test is disabled.
 *
 * Source:
 *
 * Junit
 * https://www.vogella.com/tutorials/JUnit/article.html
 * https://www.youtube.com/watch?v=dlWjn4QrVK4
 * https://developer.android.com/training/testing/unit-testing/local-unit-tests
 *
 * Mockito
 * https://www.vogella.com/tutorials/Mockito/article.html
 *
 * Robolectric
 * http://robolectric.org/
 *
 * Asserting Function needed for completing the test
 * assertTrue():
 * assertFalse():
 *
 * Example for Mocking Database
 * @Mock
 * var databaseMock: MyDatabase? = null
 *
 * Tells Mockito to create the mocks based on the @Mock annotation
 * @Rule
 * var mockitoRule: MockitoRule? = MockitoJUnit.rule()
 */

class AuthViewModelTest {

    @Ignore
    @Test
    fun onLoginButtonClick_success() {
        var email = "probelalkhan@gmail.com"
        var password = "123456"
        //You can create a new instace for myApi
        val myApi = MyApi
        val call: Call<ResponseBody> = myApi().userlogin(email, password)

        try { //Magic is here at .execute() instead of .enqueue()
            val response: Response<ResponseBody> = call.execute()
            val responseBody: ResponseBody? = response.body()
            //You may also assert responseBody model message here
            assertTrue(response.isSuccessful)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Ignore
    @Test
    fun onLoginButtonClick_failed() {
        var email = "belalkhan@gmail.com"
        var password = "123456"

        //You can directly use the api
        val call: Call<ResponseBody> = MyApi().userlogin(email, password)

        try { //Magic is here at .execute() instead of .enqueue()
            val response: Response<ResponseBody> = call.execute()
            val responseBody: ResponseBody? = response.body()
            assertTrue(!response.isSuccessful)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}