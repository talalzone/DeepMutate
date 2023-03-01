package io.zenmake.deepmutate.plugins.build.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Talal Ahmed on 25/02/2023
 */
public final class SurefireReport {

    private SurefireReport() {
    }

    public static TestReport get(File xmlReportPath) throws IOException {
        var objectMapper = new XmlMapper();
        var report = objectMapper.readValue(xmlReportPath, TestReport.class);
        return report;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TestReport {

        @JacksonXmlProperty(isAttribute = true)
        public String name;

        @JacksonXmlProperty(isAttribute = true)
        public String tests;

        @JacksonXmlProperty(isAttribute = true)
        public String failures;

        @JacksonXmlProperty(isAttribute = true)
        public String errors;

        @JacksonXmlProperty(isAttribute = true)
        public String skipped;

        @JacksonXmlProperty(isAttribute = true)
        public String time;

        @JacksonXmlElementWrapper(useWrapping = false)
        public List<Testcase> testcase;

        public TestReport() {
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Testcase {

            @JacksonXmlProperty(isAttribute = true)
            public String classname;

            @JacksonXmlProperty(isAttribute = true)
            public String name;

            @JacksonXmlProperty(isAttribute = true)
            public String time;

            @JacksonXmlProperty(localName = "failure")
            public Failure failure;

            public Testcase() {
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Failure {

                public Failure() {
                }

                @JacksonXmlProperty(isAttribute = true)
                public String message;

                @JacksonXmlProperty(isAttribute = true)
                public String type;

                @JacksonXmlText
                public String content;
            }
        }
    }
}
