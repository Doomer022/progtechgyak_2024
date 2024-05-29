# Rendszerterv
## 1. A rendszer célja

Az alkalmazás célja egy országos Rally motorsport esemény kezelő szoftveralkalmazás létrehozása. Amelyben lehet a jövőben esedéses eseményekre regisztrálni, és értesítést kapni róluk. Valamint az események további adatait is meg lehet tekinteni.
## 2. Projektterv

A projektet Java programnyelven fejlesztjük, bizonyos tervezési minták felhasználásával, a követelményeknek megfelelően.

## 3. Folyamatok modellje

![rednszerterv](https://github.com/Doomer022/progtechgyak_2024/assets/117568964/c3ba7de2-8878-4e83-9522-15b92b696c70)

## 4. Követelmények

### Funkcionális követelmények

- Események, Versenyzők, Autók, Pályák rögzítése az adatbázisban
- Adatok megjelenítése a felületen
- Jelentkezés közelgő eseményre
- Értesítés a közelgő érdekelt eseményről
 
### Nemfunkcionális követelmények

- Java nyelv használata fejlesztéshez
- Az alkalmazás adatbázishoz kapcsolódik
- Tervezési minták használata

### 5. Fejlesztő eszközök

A fejlesztés során használt eszközök:
- IntelliJ Idea Ultimate Edition
- Gluon SceneBuilder
- GitHub

## 6. Architekturális terv

### Adatbázis rendszer

A szoftver SQLite adatbázis szervert használ.

### A program elérése, kezelése

A programnak el kell tudni érnie az adatbázis-szervert, továbbá rendelkeznie kell Java futtatókörnyezettel.

## 7. Adatbázis terv

![adatbazisterv](https://github.com/Doomer022/progtechgyak_2024/assets/117568964/0c8be8c3-184c-4c04-bafb-36c405c95474)

## 8. Implementációs terv

A szoftver fejlesztését a Java programozási nyelven hajtjuk végre, a felület JavafX alapú, az adatbázis pedig SQLite rendszerrel épül fel. Ügyelünk kell a program lépéseinek logolására, illetve az OCP és SRP szabályainak betartására. Terv szerint a **Proxy** és **command** tervezési mintákat használjuk fel.

## 9. Tesztterv

A programot elsősorban unit tesztek segítségével teszteljük JUnit-tal, a manuális tesztelésen kívül.

## 10. Telepítési terv

Az alkalmazás önmagában nem igényel telepítést, viszont szükséges hozzá valamilyen Java futtatókörnyezet telepítése, ennek a telepítésének a menete az operációs rendszertől függ, ez megtalálható a Java dokumentációban.

## 11. Karbantartási terv

A Java-keretrendszert három havonta frissíteni kell, és javítani kell azokat a részeket, amelyek az új verzió során elavultakká váltak. Figyelni kell a felhasználók által jelzett szoftverhibákra, és súlyosság szerint kell prioritásba venni őket (hotfixek kritikus hibák javítására, havi frissítések kisebbekre). Választék bővítése esetén bővítendő a szoftver is.
