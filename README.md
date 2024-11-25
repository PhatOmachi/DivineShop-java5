
# Đây là project clone nghiệp vụ của DivineShop (CodeOxi)

- Tất cả những thông tin trong project đều là ảo không có thật, chúng tôi chỉ lấy dữ liệu từ web về và xây dừng nên dựa theo kiến thực của chúng tôi.
- Bài này được thực hiện và hoàn thành trong vòng 1 tháng.
- Project sẽ luôn cập nhật.
## Các thành viên trong nhóm

Cảm ơn sự đóng góp của các thành viên:

- [Nguyễn Tấn Lộc - `Backend`](https://www.facebook.com/profile.php?id=100041240477371)
- [Phùng Châu Phát - `Backend`](https://www.facebook.com/chauphat2111)
- [Nguyễn Hồ Phát - `Backend`](https://www.facebook.com/profile.php?id=100010361110406)
- [Phạm Gia Huy - `Frontend`](https://www.facebook.com/phamgia.huy.3990)
- [Nguyễn Văn Trường An - `DevOps`](https://www.facebook.com/TruongAnDev)

## Các công nghệ sử dụng trong project

**`Front-end:`** Html, Js, Css, Bootstrap, JQuery(call API), ReactJS

**`Back-end:`** Spring boot

**`Server:`** Azure (Ubuntu 22.04)

**`CI/CD:`** GitHub Action


## Các account được sử dụng trong project với các quyền

**Admin**
- `Tài khoản` : susan
- `Mật khẩu` : test123


**User**
- `Bạn có thể tạo theo cách của 1 user sài bình thường`

## Cách thức để chạy project
- B1 : `Bạn clone project về `
- B2 : `Thực hiện chạy 3 file SQL trong thư mục sql`
    ```bash
    - Create_SQL_Java5_Divineshop.sql
    - Insert_SQL_Java5_Divineshop.sql
    - Trigger_SQL_Java5_Divineshop.sql
    ```
- B3 : `Vào trong project tìm đến thư mục resources và đến file application.properties`
    - Thực hiện thay đổi spring.datasource.url = 'Connection strings đến database'

- B4 : `Run project và trải nghiệm`


```bash
*Lưu ý khi chạy project nếu bạn có chạy 1 project khác thì rất có thể  sẽ bị trùng port với nhau (thực hiện thay đổi port)
    -- Tìm đến thư mục resources và đến file application.properties
        -> Tìm đến server.port hiện tại là 8080 
            -> thay đổi thành server.port = `8081 hoặc tùy ý bạn`
    --> Start lại project để trải nghiệm.
```

    
## Câu hỏi cho project

Nếu bạn có câu hỏi nào về project hoặc có lỗi trong project thì liên hệ mình - [Nguyễn Hồ Phát](https://www.facebook.com/profile.php?id=100010361110406)

