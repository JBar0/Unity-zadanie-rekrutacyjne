# Zadanie rekrutacyjne Unity
## Opis aplikacji 
Aplikacji umożliwia naliczenie rabatu dla produktów w wysokości proporcjonalnej do ich ceny.

Dostępny endpoint:
* GET /discount

Przykładowe ciało zapytania:
```JSON
{
    "productList": [
        {
            "name": "Product1",
            "price": 1500
        },
        {
            "name": "Product1",
            "price": 500
        }
    ],
    "discount": 100
}
```

Przykładowa odpowiedź:
```JSON
{
    "productList": [
        {
            "name": "Product1",
            "price": 1500.0,
            "discount": 75.0
        },
        {
            "name": "Product1",
            "price": 500.0,
            "discount": 25.0
        }
    ],
    "discount": 100.0
}
```

## Uruchomienie aplikacji 

```bash
    docker build -t unity:latest .
    docker run -p 8080:8080 unity
```
