
<a name="paths"></a>
## Paths

<a name="hellousingget"></a>
### go方法
```
GET /go
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**go**  <br>*optional*|go参数|string|
|**Query**|**hello**  <br>*optional*|hello参数|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `*/*`


#### Tags

* 测试2


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="hellousingget_1"></a>
### hello方法
```
GET /hello
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**hello**  <br>*optional*|入参|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `*/*`


#### Tags

* 测试一


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="createusingpost"></a>
### 创建用户
```
POST /users
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**user**  <br>*required*|user|[用户基本信息](#f27103dead187fe6c304ecd07f70768d)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[用户基本信息](#f27103dead187fe6c304ecd07f70768d)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 用户管理


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="listusingget"></a>
### 用户列表
```
GET /users
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**pageIndex**  <br>*optional*|查看第几页|integer (int32)|
|**Query**|**pageSize**  <br>*optional*|每页多少条|integer (int32)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [用户基本信息](#f27103dead187fe6c304ecd07f70768d) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `*/*`


#### Tags

* 用户管理


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="findbyidusingget"></a>
### 用户详情
```
GET /users/{id}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[用户基本信息](#f27103dead187fe6c304ecd07f70768d)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `*/*`


#### Tags

* 用户管理


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|



