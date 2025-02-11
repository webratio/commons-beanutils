/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.beanutils.converters;

import java.util.Calendar;
import junit.framework.TestSuite;

/**
 * Test Case for the CalendarConverter class.
 *
 * @version $Revision$
 */
public class CalendarConverterTestCase extends DateConverterTestBase {

    /**
     * Construct a new Calendar test case.
     * @param name Test Name
     */
    public CalendarConverterTestCase(String name) {
        super(name);
    }

    // ------------------------------------------------------------------------

    /**
     * Create Test Suite
     * @return test suite
     */
    public static TestSuite suite() {
        return new TestSuite(CalendarConverterTestCase.class);        
    }

    // ------------------------------------------------------------------------
    /**
     * Create the Converter with no default value.
     * @return A new Converter
     */
    protected DateTimeConverter makeConverter() {
        return new CalendarConverter();
    }
    
    /**
     * Create the Converter with a default value.
     * @param defaultValue The default value
     * @return A new Converter
     */
    protected DateTimeConverter makeConverter(Object defaultValue) {
        return new CalendarConverter(defaultValue);
    }

    /**
     * Return the expected type
     * @return The expected type
     */
    protected Class getExpectedType() {
        return Calendar.class;
    }

    /**
     * Convert from a java.util.Date to the Converter's type.
     * 
     * @param value The Date value to convert
     * @return The converted value
     */
    protected Object toType(Calendar value) {
        return value;
   }

}