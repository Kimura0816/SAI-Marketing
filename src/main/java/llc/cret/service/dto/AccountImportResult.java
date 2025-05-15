package llc.cret.service.dto;

import llc.cret.repository.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountImportResult {

    /** エラーデータ */
    private List<CSVRecord> rejectData;
    /** 登録口座 */
    private List<Account> imported;

}
