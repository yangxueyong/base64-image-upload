# base64-image-upload
自定义签名，并上传


前端使用html(canvas)+js实现在线签名，然后将其转为图片并获取其base64字符串，最后将base64转为Blob对象传递到后端。

不建议在后端使用String来接收base64字符串，因为图片转为base64字符通常都比较大，有可能超出java的String最长限制，因此建议使用Blob。


