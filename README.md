# PaymentForm

## Overview
決済受付画面

## Description
入力フォームに決済金額が入力されると、受け取った金額をAPIに送信する。
APIから返却された決済受付結果を画面に表示する。

## Package
```
main
  java
    jp.co.gateway.yokota.form      
       Controller
          AmountController         
       form
          AmountForm            
       service
          AmountService          
       model
          YGatewayRequestModel
          YGatewayResponseModel
       client
          YGatewayClient
