/* SPDX-License-Identifier: Apache-2.0 */
package org.odpi.openmetadata.frameworks.connectors.properties.beans;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Verify the OriginStatus enum contains unique ordinals, non-null names and descriptions and can be
 * serialized to JSON and back again.
 */
public class TestElementOrigin
{
    private List<Integer> existingOrdinals = null;

    /**
     * Validate that a supplied ordinal is unique.
     *
     * @param ordinal value to test
     * @return boolean result
     */
    private boolean isUniqueOrdinal(int  ordinal)
    {
        Integer       newOrdinal = new Integer(ordinal);

        if (existingOrdinals.contains(newOrdinal))
        {
            return false;
        }
        else
        {
            existingOrdinals.add(newOrdinal);
            return true;
        }
    }


    /**
     * Validated the values of the enum.
     */
    @Test public void testElementOriginValues()
    {
        existingOrdinals = new ArrayList<>();

        ElementOrigin  testValue;

        testValue = ElementOrigin.LOCAL_COHORT;

        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getDescription() != null);

        testValue = ElementOrigin.EXPORT_ARCHIVE;

        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getDescription() != null);

        testValue = ElementOrigin.CONTENT_PACK;

        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getDescription() != null);

        testValue = ElementOrigin.DEREGISTERED_REPOSITORY;

        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getDescription() != null);


        testValue = ElementOrigin.CONFIGURATION;

        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getDescription() != null);
    }


    /**
     * Validate that an object generated from a JSON String has the same content as the object used to
     * create the JSON String.
     */
    @Test public void testJSON()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonString   = null;

        try
        {
            jsonString = objectMapper.writeValueAsString(ElementOrigin.CONTENT_PACK);
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            assertTrue(objectMapper.readValue(jsonString, ElementOrigin.class) == ElementOrigin.CONTENT_PACK);
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }
    }


    /**
     * Test that toString is overridden.
     */
    @Test public void testToString()
    {
        assertTrue(ElementOrigin.CONFIGURATION.toString().contains("ElementOrigin"));
    }
}
