package com.asc.als.retrofit.naver.util;

import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig;
import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserBucket;


public class AscDateTimeDeserializer extends DateTimeDeserializer {

    public AscDateTimeDeserializer() {
        super(LocalDateTime.class, FormatConfig.DEFAULT_DATETIME_PARSER);
    }

    public AscDateTimeDeserializer(Class<?> cls, JacksonJodaDateFormat format) {
        super(cls, format);
    }

}
