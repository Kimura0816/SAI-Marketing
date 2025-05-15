package llc.cret.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class CsvUtil {

    public static List<CSVRecord> parse(BufferedReader reader) {
        List<CSVRecord> list = new LinkedList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.builder()
                .setCommentMarker('#')
                .setHeader()
                .setSkipHeaderRecord(true)
                .get()
                .parse(reader)) {
            for (CSVRecord csvRecord : parser) {
                log.debug(csvRecord.toString());
                list.add(csvRecord);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}
