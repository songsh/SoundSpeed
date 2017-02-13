package nobleworks.libmpg.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import nobleworks.libmpg.Encoding;
import android.test.AndroidTestCase;
import static org.hamcrest.Matchers.*;
import static nobleworks.libmpg.test.HamcrestAssert.*;

public class EncodingTest extends AndroidTestCase
{
    // This tests that there are 
    public void testOrdinalValuesAreCorrect()
        throws IllegalArgumentException, IllegalAccessException
    {
        for(Encoding e: Encoding.values())
        {
            try
            {
                Field f = Encoding.Ordinals.class.getField(e.name());
                int modifiers = f.getModifiers();

                assertTrue( f + " is not static", Modifier.isStatic(modifiers));
                assertTrue( f + " is not final", Modifier.isFinal(modifiers));
            
                assertEquals("Value of " + f, e.ordinal(), f.getInt(null));
            }
            catch(NoSuchFieldException ex)
            {
                fail("Encoding.Ordinals." + e + " is not defined.");
            }
        }
    }
    
    public void testAttributesOf_ULAW_8()
    {
        Encoding encoding = Encoding.ULAW_8;
        assertEquals(encoding + ".getBits()", 8, encoding.getBits());
        assertEquals(encoding + ".isSigned()", false, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.ULAW, encoding.getFormat());
    }
    
    public void testAttributesOf_ALAW_8()
    {
        Encoding encoding = Encoding.ALAW_8;
        assertEquals(encoding + ".getBits()", 8, encoding.getBits());
        assertEquals(encoding + ".isSigned()", false, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.ALAW, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_SIGNED_8()
    {
        Encoding encoding = Encoding.PCM_SIGNED_8;
        assertEquals(encoding + ".getBits()", 8, encoding.getBits());
        assertEquals(encoding + ".isSigned()", true, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_UNSIGNED_8()
    {
        Encoding encoding = Encoding.PCM_UNSIGNED_8;
        assertEquals(encoding + ".getBits()", 8, encoding.getBits());
        assertEquals(encoding + ".isSigned()", false, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_SIGNED_16()
    {
        Encoding encoding = Encoding.PCM_SIGNED_16;
        assertEquals(encoding + ".getBits()", 16, encoding.getBits());
        assertEquals(encoding + ".isSigned()", true, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_UNSIGNED_16()
    {
        Encoding encoding = Encoding.PCM_UNSIGNED_16;
        assertEquals(encoding + ".getBits()", 16, encoding.getBits());
        assertEquals(encoding + ".isSigned()", false, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_SIGNED_24()
    {
        Encoding encoding = Encoding.PCM_SIGNED_24;
        assertEquals(encoding + ".getBits()", 24, encoding.getBits());
        assertEquals(encoding + ".isSigned()", true, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_UNSIGNED_24()
    {
        Encoding encoding = Encoding.PCM_UNSIGNED_24;
        assertEquals(encoding + ".getBits()", 24, encoding.getBits());
        assertEquals(encoding + ".isSigned()", false, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_SIGNED_32()
    {
        Encoding encoding = Encoding.PCM_SIGNED_32;
        assertEquals(encoding + ".getBits()", 32, encoding.getBits());
        assertEquals(encoding + ".isSigned()", true, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_UNSIGNED_32()
    {
        Encoding encoding = Encoding.PCM_UNSIGNED_32;
        assertEquals(encoding + ".getBits()", 32, encoding.getBits());
        assertEquals(encoding + ".isSigned()", false, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", false, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_FLOAT_32()
    {
        Encoding encoding = Encoding.PCM_FLOAT_32;
        assertEquals(encoding + ".getBits()", 32, encoding.getBits());
        assertEquals(encoding + ".isSigned()", true, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", true, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
    
    public void testAttributesOf_PCM_FLOAT_64()
    {
        Encoding encoding = Encoding.PCM_FLOAT_64;
        assertEquals(encoding + ".getBits()", 64, encoding.getBits());
        assertEquals(encoding + ".isSigned()", true, encoding.isSigned());
        assertEquals(encoding + ".isFloatingPoint()", true, encoding.isFloatingPoint());
        assertEquals(encoding + ".getFormat()", Encoding.Format.PCM, encoding.getFormat());
    }
}
