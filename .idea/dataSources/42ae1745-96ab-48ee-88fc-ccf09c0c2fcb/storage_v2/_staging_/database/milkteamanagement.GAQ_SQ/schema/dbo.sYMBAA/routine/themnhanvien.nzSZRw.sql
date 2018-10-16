ALTER PROCEDURE themNhanVien
  @ten nvarchar(50),
  @ca bit,
  @sdt char(10),
  @luong int,
  @thuong int
  as
  begin
    insert into NhanVien
    values (@ten, @ca, @sdt, @luong, @thuong)
  end
go

