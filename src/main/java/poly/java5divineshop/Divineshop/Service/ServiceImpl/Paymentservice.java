package poly.java5divineshop.Divineshop.Service.ServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.java5divineshop.Divineshop.ConfigVnPay.VNPAYConfig;
import poly.java5divineshop.Divineshop.Data.Dto.PaymentDTO;
import poly.java5divineshop.Divineshop.Data.Entity.PaymentE;
import poly.java5divineshop.Divineshop.Repo.PaymentRepo;
import poly.java5divineshop.Divineshop.Utils.VNPayUtil;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Paymentservice {
    private final VNPAYConfig vnPayConfig;

    @Autowired
    PaymentRepo repo;

    public PaymentDTO.VNPayResponse createVnPayPayment(HttpServletRequest request, String name) {
        long amount = Integer.parseInt(request.getParameter("amount")) * 100L;
        String bankCode = request.getParameter("bankCode");
        Map<String, String> vnpParamsMap = vnPayConfig.getVNPayConfig();
        vnpParamsMap.put("vnp_Amount", String.valueOf(amount));
        if (bankCode != null && !bankCode.isEmpty()) {
            vnpParamsMap.put("vnp_BankCode", bankCode);
        }
        vnpParamsMap.put("vnp_IpAddr", VNPayUtil.getIpAddress(request));
        vnpParamsMap.put("vnp_OrderInfo", "Thanh toan don hang-" +  name);
        //build query url
        String queryUrl = VNPayUtil.getPaymentURL(vnpParamsMap, true);
        String hashData = VNPayUtil.getPaymentURL(vnpParamsMap, false);
        String vnpSecureHash = VNPayUtil.hmacSHA512(vnPayConfig.getSecretKey(), hashData);
        queryUrl += "&vnp_SecureHash=" + vnpSecureHash;
        String paymentUrl = vnPayConfig.getVnp_PayUrl() + "?" + queryUrl;
        return PaymentDTO.VNPayResponse.builder()
                .code("ok")
                .message("success")
                .paymentUrl(paymentUrl).build();
    }

    public void save (PaymentE paymentE){
        repo.save(paymentE);
    }

    public void updatepaymentbyuser (String name){
        repo.UpdatePaymentByuser(true,name);
    }

    public PaymentE findByTenuser (String tenuser){
        return repo.findByTenuser(tenuser);
    }

    public List<PaymentE> findAllByTenuser (String tenuser){
        return repo.findAllByTenuser(tenuser);
    }
}
