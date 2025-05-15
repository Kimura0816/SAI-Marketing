package llc.cret.controller.admin;

import llc.cret.controller.dto.CompanyDto;
import llc.cret.controller.dto.CompanyRequestDto;
import llc.cret.controller.dto.CompanyResponsetDto;
import llc.cret.repository.entity.Company;
import llc.cret.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    /**
     * 会社登録.
     * @param body
     * @return 会社情報.
     */
    @RequestMapping(value = "/rest/company", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<CompanyResponsetDto> doRegist(@RequestBody CompanyRequestDto body) {

        Company company = toEntity(body.getForm());
        Company result = companyService.regist(company);
        CompanyResponsetDto res = CompanyResponsetDto.builder()
                .result(Collections.singletonList(toDto(result))).build();

        return ResponseEntity.ok(res);
    }

    /**
     * 会社更新.
     * @param body
     * @return 会社情報.
     */
    @RequestMapping(value = "/rest/company", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<CompanyResponsetDto> doUpdate(@RequestBody CompanyRequestDto body) {

        Company company = toEntity(body.getForm());
        Company result = companyService.update(company);
        CompanyResponsetDto res = CompanyResponsetDto.builder()
                .result(Collections.singletonList(toDto(result))).build();

        return ResponseEntity.ok(res);
    }

    /**
     * 会社削除.
     * @param body
     * @return 会社情報.
     */
    @RequestMapping(value = "/rest/company", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity<CompanyResponsetDto> doDelete(@RequestBody CompanyRequestDto body) {

        log.info(body.toString());
        Company company = toEntity(body.getForm());
        companyService.remove(company);
        CompanyResponsetDto res = CompanyResponsetDto.builder().build();

        return ResponseEntity.ok(res);
    }

    /**
     * 会社検索.
     * @param body
     * @return 会社情報.
     */
    @RequestMapping(value = "/rest/company-query", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<CompanyResponsetDto> doFind(@RequestBody CompanyRequestDto body) {
        Company conditions = toEntity(body.getForm());
        List<Company> result = companyService.find(conditions);
        ArrayList<CompanyDto> resultDto = new ArrayList<>();
        for (Company company : result) {
            resultDto.add(toDto(company));
        }
        CompanyResponsetDto res = CompanyResponsetDto.builder().result(resultDto).build();

        return ResponseEntity.ok(res);
    }

    /**
     * DTOからEntityへのコンバート.
     * @param dto 会社DTO
     * @return 会社エンティティ
     */
    private Company toEntity(CompanyDto dto) {
        return Company.builder()
                .companyCd(dto.getCompanyCd())
                .companyName(dto.getCompanyName())
                .auth(dto.getAuth())
                .companyUrl(dto.getCompanyUrl())
                .specialSalesUrl(dto.getSpecialSalesUrl())
                .puraporiUrl(dto.getPuraporiUrl())
                .email(dto.getEmail())
                .tel(dto.getTel())
                .build();
    }

    /**
     * DTOからEntityへのコンバート.
     * @param entity 会社エンティティ
     * @return 会社DTO
     */
    private CompanyDto toDto(Company entity) {
        return CompanyDto.builder()
                .companyCd(entity.getCompanyCd())
                .companyName(entity.getCompanyName())
                .auth(entity.getAuth())
                .companyUrl(entity.getCompanyUrl())
                .specialSalesUrl(entity.getSpecialSalesUrl())
                .puraporiUrl(entity.getPuraporiUrl())
                .email(entity.getEmail())
                .tel(entity.getTel())
                .build();
    }
}
