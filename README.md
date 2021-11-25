# ppkwu_lab4
# Documentation API

This API enables conversion between different data formats and also allows downloading string stats and print them in specified format
# Data format conversion
## Description

Below endpoints convert different kinds of data formats

|type|endpoint|
|---|---|
|POST|/api/converter/{input_format}/json|
|POST|/api/converter/{input_format}/xml|
|POST|/api/converter/{input_format}/csv|
|POST|/api/converter/{input_format}/txt|

Available {input_format} data:<br>
json<br>
xml<br>
csv<br>
txt<br>

### Example 1, convert xml to json

```
http://localhost:8082/api/converter/xml/json
```

<b>Input body</b>
```xml
<data>
    <str>al4/A3zSa9ot_tyOx-ek*</str>
    <numberOfUppercase>3</numberOfUppercase>
    <numberOfSpecialChars>4</numberOfSpecialChars>
    <numberOfLowercase>11</numberOfLowercase>
    <numberOfDigits>3</numberOfDigits>
</data>
```
<b>Response result</b>

```json
{
  "str": "al4/A3zSa9ot_tyOx-ek*",
  "numberOfUppercase": 3,
  "numberOfSpecialChars": 4,
  "numberOfLowercase": 11,
  "numberOfDigits": 3
}
```
### Example 2, convert json to csv

```
http://localhost:8082/api/converter/json/csv
```

<b>Input body</b>
```json
{
  "str": "al4/A3zSa9ot_tyOx-ek*",
  "numberOfUppercase": 3,
  "numberOfSpecialChars": 4,
  "numberOfLowercase": 11,
  "numberOfDigits": 3
}
```
<b>Response result</b>
```
str,numberOfUppercase,numberOfSpecialChars,numberOfLowercase,numberOfDigits
al4/A3zSa9ot_tyOx-ek*,3,4,11,3
```
### Example 3, convert csv to txt

```
http://localhost:8082/api/converter/csv/txt
```

<b>Input body</b>
```
str,numberOfUppercase,numberOfSpecialChars,numberOfLowercase,numberOfDigits
al4/A3zSa9ot_tyOx-ek*,3,4,11,3
```
<b>Response result</b>
```
str: al4/A3zSa9ot_tyOx-ek*
numberOfUppercase: 3
numberOfSpecialChars: 4
numberOfLowercase: 11
numberOfDigits: 33
```
### Example 4, convert txt to xml

```
http://localhost:8082/api/converter/txt/xml
```

<b>Input body</b>
```
str: al4/A3zSa9ot_tyOx-ek*
numberOfUppercase: 3
numberOfSpecialChars: 4
numberOfLowercase: 11
numberOfDigits: 3
```
<b>Response result</b>
```xml
<data>
    <str>al4/A3zSa9ot_tyOx-ek*</str>
    <numberOfUppercase>3</numberOfUppercase>
    <numberOfSpecialChars>4</numberOfSpecialChars>
    <numberOfLowercase>11</numberOfLowercase>
    <numberOfDigits>3</numberOfDigits>
</data>
```