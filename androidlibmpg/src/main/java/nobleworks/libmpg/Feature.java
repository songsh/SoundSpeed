package nobleworks.libmpg;

/**
 * Flag definitions for the features that can be queried for using getFeatures()
 */
public enum Feature
{
    ABI_UTF8OPEN,      // mpg123 expects path names to be given in UTF-8 encoding instead of plain native.
    OUTPUT_8BIT,       // 8bit output
    OUTPUT_16BIT,      // 16bit output
    OUTPUT_32BIT,      // 32bit output
    INDEX,             // support for building a frame index for accurate seeking
    PARSE_ID3V2,       // id3v2 parsing
    DECODE_LAYER1,     // mpeg layer-1 decoder enabled
    DECODE_LAYER2,     // mpeg layer-2 decoder enabled
    DECODE_LAYER3,     // mpeg layer-3 decoder enabled
    DECODE_ACCURATE,   // accurate decoder rounding
    DECODE_DOWNSAMPLE, // downsample (sample omit)
    DECODE_NTOM,       // flexible rate decoding
    PARSE_ICY,         // ICY support
    TIMEOUT_READ;      // Reader with timeout (network).

    private static native boolean isFeatureSupported(int value);

    public boolean isSupported()
    {
        return isFeatureSupported(ordinal());
    }
}