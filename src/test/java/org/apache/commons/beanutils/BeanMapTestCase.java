/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

import junit.framework.Test;
import junit.textui.TestRunner;

import org.apache.commons.collections.map.AbstractTestMap;
import org.apache.commons.collections.BulkTest;
import org.apache.commons.collections.Transformer;

/**
 * Test cases for BeanMap
 * 
 * @version $Revision$ $Date$
 * 
 * @author Morgan Delagrange
 * @author Stephen Colebourne
 */
public class BeanMapTestCase extends AbstractTestMap {

    public BeanMapTestCase(String testName) {
        super(testName);
    }
    
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        return BulkTest.makeSuite(BeanMapTestCase.class);
    }

/*
  note to self.  The getter and setter methods were generated by copying the
  field declarations and using the following regular expression search and
  replace:

  From:
        private \(.*\) some\(.*\);
  To:
        public \1 getSome\2Value() {
            return some\2;
        }
        public void setSome\2Value(\1 value) {
            some\2 = value;
        } 

  Also note:  The sample keys and mappings were generated manually.
*/


    public static class BeanWithProperties implements Serializable {
        private int someInt;
        private long someLong;
        private double someDouble;
        private float someFloat;
        private short someShort;
        private byte someByte;
        private char someChar;
        private Integer someInteger;
        private String someString;
        private Object someObject;

        public int getSomeIntValue() {
            return someInt;
        }
        public void setSomeIntValue(int value) {
            someInt = value;
        }

        public long getSomeLongValue() {
            return someLong;
        }
        public void setSomeLongValue(long value) {
            someLong = value;
        }

        public double getSomeDoubleValue() {
            return someDouble;
        }
        public void setSomeDoubleValue(double value) {
            someDouble = value;
        }

        public float getSomeFloatValue() {
            return someFloat;
        }
        public void setSomeFloatValue(float value) {
            someFloat = value;
        }

        public short getSomeShortValue() {
            return someShort;
        }
        public void setSomeShortValue(short value) {
            someShort = value;
        }

        public byte getSomeByteValue() {
            return someByte;
        }
        public void setSomeByteValue(byte value) {
            someByte = value;
        }

        public char getSomeCharValue() {
            return someChar;
        }
        public void setSomeCharValue(char value) {
            someChar = value;
        }

        public String getSomeStringValue() {
            return someString;
        }
        public void setSomeStringValue(String value) {
            someString = value;
        }

        public Integer getSomeIntegerValue() {
            return someInteger;
        }
        public void setSomeIntegerValue(Integer value) {
            someInteger = value;
        }

        public Object getSomeObjectValue() {
            return someObject;
        }
        public void setSomeObjectValue(Object value) {
            someObject = value;
        }
    }
    
    // note to self.  The Sample keys were generated by copying the field
    // declarations and using the following regular expression search and replace:
    //
    // From:
    //    private \(.*\) some\(.*\);
    // To:
    //    "some\2Value",
    //
    // Then, I manually added the "class" key, which is a property that exists for
    // all beans (and all objects for that matter.
    public Object[] getSampleKeys() {
        Object[] keys = new Object[] {
            "someIntValue",
            "someLongValue",
            "someDoubleValue",
            "someFloatValue",
            "someShortValue",
            "someByteValue",
            "someCharValue",
            "someIntegerValue",
            "someStringValue",
            "someObjectValue",
            "class",
        };
        return keys;
    }

    /**
     *  An object value that will be stored in the bean map as a value.  Need
     *  to save this externally so that we can make sure the object instances
     *  are equivalent since getSampleValues() would otherwise construct a new
     *  and different Object each time.
     **/
    private Object objectInFullMap = new Object();

    // note to self: the sample values were created manually
    public Object[] getSampleValues() {
        Object[] values = new Object[] {
            new Integer(1234),
            new Long(1298341928234L),
            new Double(123423.34),
            new Float(1213332.12f),
            new Short((short)134),
            new Byte((byte)10),
            new Character('a'),
            new Integer(1432),
            "SomeStringValue",
            objectInFullMap,
            BeanWithProperties.class,
        };
        return values;
    }

    public Object[] getNewSampleValues() {
        Object[] values = new Object[] {
            new Integer(223),
            new Long(23341928234L),
            new Double(23423.34),
            new Float(213332.12f),
            new Short((short)234),
            new Byte((byte)20),
            new Character('b'),
            new Integer(232),
            "SomeNewStringValue",
            new Object(),
            null,
        };
        return values;
    }

    /**
     * Values is a dead copy in BeanMap, so refresh each time.
     */
    public void verifyValues() {
        values = map.values();
        super.verifyValues();
    }

    /**
     * The mappings in a BeanMap are fixed on the properties the underlying
     * bean has.  Adding and removing mappings is not possible, thus this
     * method is overridden to return false.
     */
    public boolean isPutAddSupported() {
        return false;
    }

    /**
     * The mappings in a BeanMap are fixed on the properties the underlying
     * bean has.  Adding and removing mappings is not possible, thus this
     * method is overridden to return false.
     */
    public boolean isRemoveSupported() {
        return false;
    }

    public Map makeFullMap() {
        // note: These values must match (i.e. .equals() must return true)
        // those returned from getSampleValues().
        BeanWithProperties bean = new BeanWithProperties();
        bean.setSomeIntValue(1234);
        bean.setSomeLongValue(1298341928234L);
        bean.setSomeDoubleValue(123423.34);
        bean.setSomeFloatValue(1213332.12f);
        bean.setSomeShortValue((short)134);
        bean.setSomeByteValue((byte)10);
        bean.setSomeCharValue('a');
        bean.setSomeIntegerValue(new Integer(1432));
        bean.setSomeStringValue("SomeStringValue");
        bean.setSomeObjectValue(objectInFullMap);
        return new BeanMap(bean);
    }

    public Map makeEmptyMap() {
        return new BeanMap();
    }

    public String[] ignoredTests() {
        // Ignore the serialization tests on collection views.
        return new String[] {
         "TestBeanMap.bulkTestMapEntrySet.testCanonicalEmptyCollectionExists",
         "TestBeanMap.bulkTestMapEntrySet.testCanonicalFullCollectionExists",
         "TestBeanMap.bulkTestMapKeySet.testCanonicalEmptyCollectionExists",
         "TestBeanMap.bulkTestMapKeySet.testCanonicalFullCollectionExists",
         "TestBeanMap.bulkTestMapValues.testCanonicalEmptyCollectionExists",
         "TestBeanMap.bulkTestMapValues.testCanonicalFullCollectionExists",
         "TestBeanMap.bulkTestMapEntrySet.testSimpleSerialization",
         "TestBeanMap.bulkTestMapKeySet.testSimpleSerialization",
         "TestBeanMap.bulkTestMapEntrySet.testSerializeDeserializeThenCompare",
         "TestBeanMap.bulkTestMapKeySet.testSerializeDeserializeThenCompare"
        };
    }

    /**
     * Need to override this method because the "clear()" method on the bean
     * map just returns the bean properties to their default states.  It does
     * not actually remove the mappings as per the map contract.  The default
     * testClear() methods checks that the clear method throws an
     * UnsupportedOperationException since this class is not add/remove
     * modifiable.  In our case though, we do not always throw that exception.
     */
    public void testMapClear() {
        //TODO: make sure a call to BeanMap.clear returns the bean to its
        //default initialization values.
    }

    /**
     * Need to override this method because the "put()" method on the bean
     * doesn't work for this type of Map.
     */
    public void testMapPut() {
        // see testBeanMapPutAllWriteable
    }

    public void testBeanMapClone() {
        BeanMap map = (BeanMap)makeFullMap();
        try {
            BeanMap map2 = (BeanMap)((BeanMap)map).clone();

            // make sure containsKey is working to verify the bean was cloned
            // ok, and the read methods were properly initialized
            Object[] keys = getSampleKeys();
            for(int i = 0; i < keys.length; i++) {
                assertTrue("Cloned BeanMap should contain the same keys",
                           map2.containsKey(keys[i]));
            }
        } catch (CloneNotSupportedException exception) {
            fail("BeanMap.clone() should not throw a " +
                 "CloneNotSupportedException when clone should succeed.");
        }
    }

    public void testBeanMapPutAllWriteable() {
        BeanMap map1 = (BeanMap)makeFullMap();
        BeanMap map2 = (BeanMap)makeFullMap();
        map2.put("someIntValue", new Integer(0));
        map1.putAllWriteable(map2);
        assertEquals(map1.get("someIntValue"), new Integer(0));
    }

    public void testMethodAccessor() throws Exception {
        BeanMap map = (BeanMap) makeFullMap();
        Method method = BeanWithProperties.class.getDeclaredMethod("getSomeIntegerValue", null);
        assertEquals(method, map.getReadMethod("someIntegerValue"));
    }
    
    public void testMethodMutator() throws Exception {
        BeanMap map = (BeanMap) makeFullMap();
        Method method = BeanWithProperties.class.getDeclaredMethod("setSomeIntegerValue", new Class[] {Integer.class});
        assertEquals(method, map.getWriteMethod("someIntegerValue"));
    }

    /**
     *  Test the default transformers using the getTypeTransformer() method
     */
    public void testGetTypeTransformerMethod() {
        BeanMap beanMap = new BeanMap();
        assertEquals("Boolean.TYPE",   Boolean.TRUE,        beanMap.getTypeTransformer(Boolean.TYPE).transform("true"));
        assertEquals("Character.TYPE", new Character('B'),  beanMap.getTypeTransformer(Character.TYPE).transform("BCD"));
        assertEquals("Byte.TYPE",      new Byte((byte)1),   beanMap.getTypeTransformer(Byte.TYPE).transform("1"));
        assertEquals("Short.TYPE",     new Short((short)2), beanMap.getTypeTransformer(Short.TYPE).transform("2"));
        assertEquals("Integer.TYPE",   new Integer(3),      beanMap.getTypeTransformer(Integer.TYPE).transform("3"));
        assertEquals("Long.TYPE",      new Long(4),         beanMap.getTypeTransformer(Long.TYPE).transform("4"));
        assertEquals("Float.TYPE",     new Float("5"),      beanMap.getTypeTransformer(Float.TYPE).transform("5"));
        assertEquals("Double.TYPE",    new Double("6"),     beanMap.getTypeTransformer(Double.TYPE).transform("6"));
    }

    /**
     *  Test the default transformers via the public static Map instance
     */
    public void testGetDefaultTransformersMap() {
        BeanMap beanMap = new BeanMap();
        assertEquals("Boolean.TYPE",   Boolean.TRUE,        ((Transformer)BeanMap.defaultTransformers.get(Boolean.TYPE)).transform("true"));
        assertEquals("Character.TYPE", new Character('B'),  ((Transformer)BeanMap.defaultTransformers.get(Character.TYPE)).transform("BCD"));
        assertEquals("Byte.TYPE",      new Byte((byte)1),   ((Transformer)BeanMap.defaultTransformers.get(Byte.TYPE)).transform("1"));
        assertEquals("Short.TYPE",     new Short((short)2), ((Transformer)BeanMap.defaultTransformers.get(Short.TYPE)).transform("2"));
        assertEquals("Integer.TYPE",   new Integer(3),      ((Transformer)BeanMap.defaultTransformers.get(Integer.TYPE)).transform("3"));
        assertEquals("Long.TYPE",      new Long(4),         ((Transformer)BeanMap.defaultTransformers.get(Long.TYPE)).transform("4"));
        assertEquals("Float.TYPE",     new Float("5"),      ((Transformer)BeanMap.defaultTransformers.get(Float.TYPE)).transform("5"));
        assertEquals("Double.TYPE",    new Double("6"),     ((Transformer)BeanMap.defaultTransformers.get(Double.TYPE)).transform("6"));
    }

    /**
     *  Test the default transformers HashMap
     */
    public void testDefaultTransformersMap() {
        assertEquals("Size",     8, BeanMap.defaultTransformers.size());
        assertEquals("entrySet", 8, BeanMap.defaultTransformers.entrySet().size());
        assertEquals("keySet",   8, BeanMap.defaultTransformers.keySet().size());
        assertEquals("values",   8, BeanMap.defaultTransformers.values().size());
        assertFalse("isEmpty",      BeanMap.defaultTransformers.isEmpty());
        assertTrue("containsKey(Double)",    BeanMap.defaultTransformers.containsKey(Double.TYPE));
        assertFalse("containsKey(Object)",   BeanMap.defaultTransformers.containsKey(Object.class));
        assertTrue("containsValue(double)",  BeanMap.defaultTransformers.containsValue(BeanMap.defaultTransformers.get(Double.TYPE)));
        assertFalse("containsValue(Object)", BeanMap.defaultTransformers.containsValue(Object.class));

        try {
            BeanMap.defaultTransformers.clear();
            fail("clear() - expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected result
        }
        try {
            BeanMap.defaultTransformers.put("FOO", null);
            fail("put() - expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected result
        }
        try {
            BeanMap.defaultTransformers.putAll(new HashMap());
            fail("putAll() - expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected result
        }
        try {
            BeanMap.defaultTransformers.remove("FOO");
            fail("remove() - expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected result
        }
    }
   
}
