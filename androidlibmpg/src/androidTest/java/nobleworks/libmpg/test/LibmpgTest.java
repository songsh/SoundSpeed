package nobleworks.libmpg.test;

import static nobleworks.libmpg.test.HamcrestAssert.*;
import static org.hamcrest.Matchers.*;
import nobleworks.libmpg.Encoding;
import nobleworks.libmpg.MP3Decoder;

import org.apache.commons.lang.ArrayUtils;
import org.hamcrest.number.IsGreaterThan;
import org.mockito.internal.matchers.GreaterThan;

import android.test.AndroidTestCase;

public class LibmpgTest extends AndroidTestCase
{
    public void testSupportedRates()
    {
        int[] expectedRates =
        {
                8000, 11025, 12000, 16000, 22050, 24000, 32000, 44100, 48000
        };
        
        Integer[] supportedRates = ArrayUtils.toObject(MP3Decoder.getSupportedRates());

        for( int rate : expectedRates )
        {
            assertThat(supportedRates, hasItemInArray(rate));
        }
    }
    
    public void testSupportedEncodings()
    {
        Encoding[] expectedEncodings =
        {
                Encoding.ALAW_8, Encoding.ULAW_8,
                Encoding.PCM_UNSIGNED_8, Encoding.PCM_SIGNED_8,
                Encoding.PCM_UNSIGNED_16, Encoding.PCM_SIGNED_16,
                Encoding.PCM_UNSIGNED_24, Encoding.PCM_SIGNED_24,
                Encoding.PCM_UNSIGNED_32, Encoding.PCM_SIGNED_32,
                // Only one size of floating point is supported
                Encoding.PCM_FLOAT_64
        };

        Encoding[] unexpectedEncodings =
        {
                Encoding.PCM_UNSIGNED_24, Encoding.PCM_SIGNED_24,
                Encoding.PCM_UNSIGNED_32, Encoding.PCM_SIGNED_32,
                // Only one size of floating point is supported
                Encoding.PCM_FLOAT_32
        };

        Encoding[] supportedEncodings = MP3Decoder.getSupportedEncodings();
        
        for(Encoding encoding : expectedEncodings)
        {
            assertThat(supportedEncodings,hasItemInArray(encoding));
        }
        
        for(Encoding encoding : unexpectedEncodings)
        {
            assertThat(supportedEncodings,not(hasItemInArray(encoding)));
        }
    }
    
    public void testGettingErrorMessage()
    {
        // At least test that it doesn't die and returns a non-empty string
        String message = MP3Decoder.getErrorMessage(MP3Decoder.Error.DONE);
        
        assertThat(message.length(), greaterThan(1));
    }
    
    public void testThat8BitOutputReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.OUTPUT_8BIT.isSupported(), is(true));
    }
    
    public void testThat16BitOutputReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.OUTPUT_16BIT.isSupported(), is(true));
    }
    
    public void testThat32BitOutputReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.OUTPUT_32BIT.isSupported(), is(true));
    }
    
    public void testThatBuildingOfFrameIndexReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.INDEX.isSupported(), is(true));
    }
    
    public void testThatID3V2ParsingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.PARSE_ID3V2.isSupported(), is(true));
    }
    
    public void testThatIcyParsingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.PARSE_ICY.isSupported(), is(true));
    }
    
    public void testThatLayer1DecodingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.DECODE_LAYER1.isSupported(), is(true));
    }
    
    public void testThatLayer2DecodingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.DECODE_LAYER2.isSupported(), is(true));
    }
    
    public void testThatLayer3DecodingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.DECODE_LAYER3.isSupported(), is(true));
    }
    
    public void testThatAccurateDecodingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.DECODE_ACCURATE.isSupported(), is(true));
    }
    
    public void testThatDownSampleDecodingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.DECODE_DOWNSAMPLE.isSupported(), is(true));
    }
    
    public void testThatFlexibleRateDecodingReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.DECODE_NTOM.isSupported(), is(true));
    }
    
    public void testThatReaderWithTimeoutReportsAsSupported()
    {
        assertThat(MP3Decoder.Feature.TIMEOUT_READ.isSupported(), is(true));
    }
}
