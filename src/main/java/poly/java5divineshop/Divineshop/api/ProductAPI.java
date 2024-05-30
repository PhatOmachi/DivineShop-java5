package poly.java5divineshop.Divineshop.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poly.java5divineshop.Divineshop.Data.Dto.ProductDTO;
import poly.java5divineshop.Divineshop.Data.Model.ProductM;
import poly.java5divineshop.Divineshop.Service.ProductService;

import java.util.*;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(ProductM.convertListProductMToListProductDTO(productService.getAllProducts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try {
            Optional<ProductM> product = productService.getProductById(id);
            if (product.isPresent()) {
                result.put("success", true);
                result.put("message", "Call API thành công");
                result.put("data", product.get());
            } else {
                result.put("success", false);
                result.put("message", "Product không tồn tại");
                result.put("data", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
            }
        }catch (Exception e){
            log.error("Call api thất bại!!!",e);
            result.put("success",false);
            result.put("message","Call api thất bại");
            result.put("data",null);
            return ResponseEntity.internalServerError().body(result);
        }
        return ResponseEntity.ok(result);
//        Optional<ProductM> product = productService.getProductById(id);
//        return product.map(productTemp -> ResponseEntity.ok()
//                .body(Map.of(
//                        "success", true,
//                        "message", "Lấy thông tin sản phẩm thành công",
//                        "data", product)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            ProductM createdProduct = productService.addProduct(ProductM.convertProductDTOToProductM(productDTO));
            result.put("success", true);
            result.put("message", "Thêm sản phẩm thành công");
            result.put("data", createdProduct);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("Thêm sản phẩm thất bại!!!", e);
            result.put("success", false);
            result.put("message", "Thêm sản phẩm thất bại");
            result.put("data", null);
            return ResponseEntity.internalServerError().body(result);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            Optional<ProductM> updatedProduct = productService.updateProduct(id, ProductM.convertProductDTOToProductM(productDTO));
            if (updatedProduct.isPresent()) {
                result.put("success", true);
                result.put("message", "Call API thành công");
                result.put("data", updatedProduct.get());
            } else {
                result.put("success", false);
                result.put("message", "Product không tồn tại");
                result.put("data", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
            }
        }catch (Exception e){
            log.error("Call api thất bại!!!",e);
            result.put("success",false);
            result.put("message","Call api thất bại");
            result.put("data",null);
            return ResponseEntity.internalServerError().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean isDeleted = productService.deleteProduct(id);
            if (isDeleted) {
                result.put("success", true);
                result.put("message", "Xoá sản phẩm thành công");
                return ResponseEntity.ok(result);
            } else {
                result.put("success", false);
                result.put("message", "Sản phẩm không tồn tại");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
            }
        } catch (Exception e) {
            log.error("Xoá sản phẩm thất bại!!!", e);
            result.put("success", false);
            result.put("message", "Xoá sản phẩm thất bại");
            return ResponseEntity.internalServerError().body(result);
        }
    }
}
