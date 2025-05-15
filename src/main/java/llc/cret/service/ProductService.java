package llc.cret.service;

import jakarta.transaction.Transactional;
import llc.cret.repository.AccountRepository;
import llc.cret.repository.ProductRepository;
import llc.cret.repository.entity.Account;
import llc.cret.repository.entity.Company;
import llc.cret.repository.entity.EntityValueConst;
import llc.cret.repository.entity.Product;
import llc.cret.repository.specication.AccountSpeciification;
import llc.cret.service.dto.AccountImportResult;
import llc.cret.util.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    /**
     * 商材登録.
     * @param product 商材.
     * @return 更新後商材.
     */
    public Product regist(Product product) {
        return productRepository.save(product);
    }

    /**
     * 商材検索.
     * @param productCd 商材CD.
     * @return 商材.
     */
    public Optional<Product> findById(String productCd) {
        return productRepository.findById(Integer.parseInt(productCd));
    }

}
