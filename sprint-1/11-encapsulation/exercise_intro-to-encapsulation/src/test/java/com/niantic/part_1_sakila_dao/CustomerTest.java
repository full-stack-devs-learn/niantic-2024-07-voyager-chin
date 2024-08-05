package com.niantic.part_1_sakila_dao;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class CustomerTest extends ReflectionBase<Customer>
{
    Class<Customer> klass;

    @BeforeEach
    public void setup()
    {
        klass = Customer.class;
    }

    @Test
    public void customer_shouldHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterless constructor.\n");
    }

    @Test
    public void customer_shouldHave_parameterizedConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (customerId, firstName, lastname, email, address, city, state, zip, country, phone).\n");
    }


    @Test
    public void customer_shouldHave_getCustomerId()
    {
        // arrange
        String methodName = "getCustomerId";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setCustomerId()
    {
        // arrange
        String methodName = "setCustomerId";

        // act
        var method = getMethod(klass, methodName, int.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getFirstName()
    {
        // arrange
        String methodName = "getFirstName";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setFirstName()
    {
        // arrange
        String methodName = "setFirstName";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getLastName()
    {
        // arrange
        String methodName = "getLastName";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setLastName()
    {
        // arrange
        String methodName = "setLastName";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getEmail()
    {
        // arrange
        String methodName = "getEmail";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setEmail()
    {
        // arrange
        String methodName = "setEmail";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getAddress()
    {
        // arrange
        String methodName = "getAddress";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setAddress()
    {
        // arrange
        String methodName = "setAddress";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getCity()
    {
        // arrange
        String methodName = "getCity";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setCity()
    {
        // arrange
        String methodName = "setCity";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getState()
    {
        // arrange
        String methodName = "getState";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setState()
    {
        // arrange
        String methodName = "setState";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getZip()
    {
        // arrange
        String methodName = "getZip";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setZip()
    {
        // arrange
        String methodName = "setZip";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getCountry()
    {
        // arrange
        String methodName = "getCountry";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setCountry()
    {
        // arrange
        String methodName = "setCountry";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getPhone()
    {
        // arrange
        String methodName = "getPhone";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_setPhone()
    {
        // arrange
        String methodName = "setPhone";

        // act
        var method = getMethod(klass, methodName, String.class);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void customer_shouldHave_getFullName()
    {
        // arrange
        String methodName = "getFullName";

        // act
        var method = getMethod(klass, methodName);

        // assert
        assertNotNull(method, STR."\nThere should be a \{methodName} method.\n");
    }


    @Test
    public void getFullName_shouldReturn_CustomerFullName()
    {
        try
        {

            // arrange
            String firstName = "John";
            String lastName = "Doe";
            String expectedName = "John Doe";
            // use reflection to build the object
            var constructor = getConstructor(klass);
            Customer customer = constructor.newInstance();
            var setFirstName = getMethod(klass, "setFirstName", String.class);
            var setLastName = getMethod(klass, "setLastName", String.class);
            var getFullName = getMethod(klass, "getFullName");
            // set name values
            setFirstName.invoke(customer, firstName);
            setLastName.invoke(customer, lastName);

            // act
            String actualName = getFullName.invoke(customer).toString();

            // assert
            assertEquals(expectedName, actualName, STR."\nBecause the first and last names were set to  \{firstName}, \{lastName}.\n");
        }
        catch(Exception e)
        {
            fail("Could not create a customer");
        }
    }
}