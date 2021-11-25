# ppkwu_lab4

# Documentation API

This API enables downloading and printing string stats like number of digits, uppercase, lowercase, special chars in
specified data format Also API enables conversion between different data formats

# Downloading string stats and print them in the specified format

## Description

Below endpoints allows downloading and printing string stats in the specified formats

|type|endpoint|parameter|
|---|---|---|
|GET|api/stats/{download_format}/json/string|str|
|GET|api/stats/{download_format}/xml/string|str|
|GET|api/stats/{download_format}/csv/string|str|
|GET|api/stats/{download_format}/txt/string|str|

Available {download_format}:<br>
json<br>
xml<br>
csv<br>
txt<br>

### Example 1, downloads string stats as a csv and returns json

```
http://localhost:8082/api/stats/csv/json/string?str=al4/A3zSa9ot_tyOx-ek*
```

<b>Response result</b>

```json
{
  "str": "al4/A3zSa9ot_tyOx-ek*",
  "numberOfUppercase": "3",
  "numberOfSpecialChars": "4",
  "numberOfDigits": "3",
  "numberOfLowercase": "11"
}
```

### Example 2, downloads string stats as a json and returns xml

```
http://localhost:8082/api/stats/json/xml/string?str=al4/A3zSa9ot_tyOx-ek*
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

### Example 3, downloads string stats as a txt and returns csv

```
http://localhost:8082/api/stats/txt/csv/string?str=al4/A3zSa9ot_tyOx-ek*
```

<b>Response result</b>

```
str,numberOfUppercase,numberOfSpecialChars,numberOfLowercase,numberOfDigits
al4/A3zSa9ot_tyOx-ek*,3,4,11,3
```

### Example 4, downloads string stats as a xml and returns txt

```
http://localhost:8082/api/stats/xml/txt/string?str=al4/A3zSa9ot_tyOx-ek*
```

<b>Response result</b>

```
str: al4/A3zSa9ot_tyOx-ek*
numberOfUppercase: 3
numberOfSpecialChars: 4
numberOfLowercase: 11
numberOfDigits: 3
```

# Data format conversion

## Description

Below endpoints convert different kinds of data formats

|type|endpoint|
|---|---|
|POST|/api/converter/{input_format}/json|
|POST|/api/converter/{input_format}/xml|
|POST|/api/converter/{input_format}/csv|
|POST|/api/converter/{input_format}/txt|

Available {input_format}:<br>
json<br>
xml<br>
csv<br>
txt<br>

### Example 1, converts xml to json

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

### Example 2, converts txt to xml

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

### Example 3, converts json to csv

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

### Example 4, converts csv to txt

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