ALTER PROCEDURE suaNhanVien
  @maNV int,
  @ten nvarchar(50),
  @ca bit,
  @sdt char(10),
  @luong int,
  @thuong int
  as
  begin
    update NhanVien set ten= @ten, ca = @ca, sdt = @sdt, luong = @luong, thuong = @thuong
    where maNV = @maNV
  end
go

