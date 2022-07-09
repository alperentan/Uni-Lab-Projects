from unittest import result
from neo4j import GraphDatabase
import logging
from neo4j.exceptions import ServiceUnavailable


class App:

    def __init__(self, uri, user, password):
        self.driver = GraphDatabase.driver(uri, auth=(user, password))

    def close(self):
        self.driver.close()

    # yazara gore arama yapma
    def find_arastirmacinin_yayinlari(self, arastirmaci_adi):
        # kac tane sonuc geldigini gostermek icin counter
        counter = 1
        return_json = []
        with self.driver.session() as session:
            result = session.read_transaction(self.find_and_return_arastirmacinin_yayinlari, arastirmaci_adi)
            for row in result:
                resultyazar = session.read_transaction(self.find_and_return_yayinin_arastirmacilari, row['isim'])
                row['yazar'] = resultyazar
                return_json.append(row)
        return return_json

    # yazara gore arama yapma query
    @staticmethod
    def find_and_return_arastirmacinin_yayinlari(tx, arastirmaci_adi):
        query = (
            "MATCH (arast:Arastirmaci)--(yayin:Yayinlar)--(tur:Tur)"
            "WHERE arast.arastirmaciAdi CONTAINS $arastirmaci_adi "
            "RETURN yayin.yayinAdi AS isim, yayin.yayinYili AS yil,tur.yayinTuru AS turu,tur.yayinYeri AS yer"
        )
        result = tx.run(query, arastirmaci_adi=arastirmaci_adi)
        return [{"isim": row["isim"], "yil": row["yil"], "turu": row["turu"], "yer": row['yer']}
                for row in result]

    # yayinin butun yazarlarini bulan query
    @staticmethod
    def find_and_return_yayinin_arastirmacilari(tx, yayin_adi):
        query = (
            "MATCH(b:Yayinlar)--(a:Arastirmaci)"
            "WHERE b.yayinAdi CONTAINS $yayin_adi "
            "RETURN a.arastirmaciAdi AS yazar"
        )
        resultyazar = tx.run(query, yayin_adi=yayin_adi)
        return [rows["yazar"] for rows in resultyazar]

    # yayina gore arama yapma
    def find_yayin(self, yayin_adi):
        # kac tane sonuc geldigini gostermek icin counter koydum
        counter = 1
        return_json = []
        with self.driver.session() as session:
            result = session.read_transaction(self.find_and_return_yayin, yayin_adi)
            for row in result:
                resultyazar = session.read_transaction(self.find_and_return_yayinin_arastirmacilari, row['isim'])
                row['yazar'] = resultyazar
                return_json.append(row)
        return return_json

    # yayina gore arama query
    @staticmethod
    def find_and_return_yayin(tx, yayin_adi):
        query = (
            "MATCH (yayin:Yayinlar)--(tur:Tur)"
            "WHERE yayin.yayinAdi CONTAINS $yayin_adi "
            "RETURN yayin.yayinAdi AS isim, yayin.yayinYili AS yil,tur.yayinTuru AS turu,tur.yayinYeri AS yer"
        )
        result = tx.run(query, yayin_adi=yayin_adi)
        return [{"isim": row["isim"], "yil": row["yil"], "turu": row["turu"], "yer": row['yer']}
                for row in result]

    # yila gore arama yapma
    def find_yayinByYear(self, yayin_yili):
        # kac tane sonuc geldigini gostermek icin counter koydum
        counter = 1
        return_json = []
        with self.driver.session() as session:
            result = session.read_transaction(self.find_and_return_yayinByYear, yayin_yili)
            for row in result:
                resultyazar = session.read_transaction(self.find_and_return_yayinin_arastirmacilari, row['isim'])
                row['yazar'] = resultyazar
                return_json.append(row)
        return return_json

    # yila gore arama query
    @staticmethod
    def find_and_return_yayinByYear(tx, yayin_yili):
        query = (
            "MATCH (yayin:Yayinlar{yayinYili:$yayin_yili})--(tur:Tur)"
            "RETURN yayin.yayinAdi AS isim, yayin.yayinYili AS yil,tur.yayinTuru AS turu,tur.yayinYeri AS yer"
        )
        result = tx.run(query, yayin_yili=yayin_yili)
        return [{"isim": row["isim"], "yil": row["yil"], "turu": row["turu"], "yer": row['yer']}
                for row in result]

    # arastirmaci olusturma
    def create_arastirmaci(self, arastirmaci_adi):
        with self.driver.session() as session:
            result = session.write_transaction(
                self.create_and_return_arastirmaci, arastirmaci_adi)
            for row in result:
                print("Created arastirmaci: {a1}".format(a1=row['a1']))

    # arastirmaci olusturma query
    @staticmethod
    def create_and_return_arastirmaci(tx, arastirmaci_adi):
        query = (
            "MERGE(a1:Arastirmaci{arastirmaciAdi:$arastirmaci_adi})"
            "RETURN a1"
        )
        result = tx.run(query, arastirmaci_adi=arastirmaci_adi)
        try:
            return [{"a1": row["a1"]["arastirmaciAdi"]}
                    for row in result]
        except ServiceUnavailable as exception:
            logging.error("{query} raised an error: \n {exception}".format(
                query=query, exception=exception))
            raise

    # yayin olusturma
    def create_yayin(self, yayin_adi, yayin_yili):
        with self.driver.session() as session:
            result = session.write_transaction(
                self.create_and_return_yayin, yayin_adi, yayin_yili)
            for row in result:
                print("Created yayin: {y1}".format(y1=row['y1']))

    # yayin olusturma query
    @staticmethod
    def create_and_return_yayin(tx, yayin_adi, yayin_yili):
        yayin_yili = int(yayin_yili)
        query = (
            "MERGE(y1:Yayinlar{yayinAdi: $yayin_adi,yayinYili:$yayin_yili})"
            "RETURN y1"
        )
        result = tx.run(query, yayin_adi=yayin_adi, yayin_yili=yayin_yili)
        try:
            return [{"y1": row["y1"]["yayinAdi"]}
                    for row in result]
        except ServiceUnavailable as exception:
            logging.error("{query} raised an error: \n {exception}".format(
                query=query, exception=exception))
            raise

    # tur olusturma
    def create_tur(self, yayin_turu, yayin_yeri):
        with self.driver.session() as session:
            result = session.write_transaction(
                self.create_and_return_tur, yayin_turu, yayin_yeri)
            for row in result:
                print("Created yayin turu: {yt}".format(yt=row['yt']))

    # tur olusturma query
    @staticmethod
    def create_and_return_tur(tx, yayin_turu, yayin_yeri):
        query = (
            "MERGE(yt:Tur{yayinTuru:$yayin_turu,yayinYeri:$yayin_yeri})"
            "RETURN yt"
        )
        result = tx.run(query, yayin_turu=yayin_turu, yayin_yeri=yayin_yeri)
        try:
            return [{"yt": row["yt"]["yayinYeri"]}
                    for row in result]
        except ServiceUnavailable as exception:
            logging.error("{query} raised an error: \n {exception}".format(
                query=query, exception=exception))
            raise

    # arastirmaci-yayin baglanti olusturma
    def create_arastirmaci_yayin_baglanti(self, arastirmaci_adi, yayin_adi):
        with self.driver.session() as session:
            result = session.write_transaction(
                self.create_and_return_arastirmaci_yayin_baglanti, arastirmaci_adi, yayin_adi)
            for row in result:
                print("Created baglanti between: {a}-{y}".format(a=row['a'], y=row['y']))

    # arastirmaci-yayin baglanti olusturma query
    @staticmethod
    def create_and_return_arastirmaci_yayin_baglanti(tx, arastirmaci_adi, yayin_adi):
        query = (
            "MATCH (a:Arastirmaci),(y:Yayinlar) "
            "WHERE a.arastirmaciAdi= $arastirmaci_adi AND y.yayinAdi= $yayin_adi "
            "MERGE (a)-[yayaz:YAYIN_YAZARI]->(y) "
            "RETURN a,y "
        )
        result = tx.run(query, arastirmaci_adi=arastirmaci_adi, yayin_adi=yayin_adi)
        try:
            return [{"a": row["a"]["arastirmaciAdi"], "y": row["y"]["yayinAdi"]}
                    for row in result]
        except ServiceUnavailable as exception:
            logging.error("{query} raised an error: \n {exception}".format(
                query=query, exception=exception))
            raise

    # yayin-yer baglanti olusturma
    def create_yayin_yer_baglanti(self, yayin_adi, yayin_yeri):
        with self.driver.session() as session:
            result = session.write_transaction(
                self.create_and_return_yayin_yer_baglanti, yayin_adi, yayin_yeri)
            for row in result:
                print("Created baglanti between: {y}-{t}".format(y=row['y'], t=row['t']))

    # yayin-yer baglanti olusturma query
    @staticmethod
    def create_and_return_yayin_yer_baglanti(tx, yayin_adi, yayin_yeri):
        query = (
            "MATCH (y:Yayinlar),(t:Tur) "
            "WHERE y.yayinAdi = $yayin_adi AND t.yayinYeri =$yayin_yeri "
            "MERGE (y)-[yaylr:YAYINLANIR]->(t) "
            "RETURN y,t "
        )
        result = tx.run(query, yayin_adi=yayin_adi, yayin_yeri=yayin_yeri)
        try:
            return [{"y": row["y"]["yayinAdi"], "t": row["t"]["yayinYeri"]}
                    for row in result]
        except ServiceUnavailable as exception:
            logging.error("{query} raised an error: \n {exception}".format(
                query=query, exception=exception))
            raise

    # arastirmaci-arastirmaci baglanti olusturma
    def create_arastirmaci_arastirmaci_baglanti(self, arastirmaci_adi1, arastirmaci_adi2):
        with self.driver.session() as session:
            result = session.write_transaction(
                self.create_and_return_arastirmaci_arastirmaci_baglanti, arastirmaci_adi1, arastirmaci_adi2)
            for row in result:
                print("Created baglanti between: {a1}-{a2}".format(a1=row['a1'], a2=row['a2']))

    # arastirmaci-arastirmaci baglanti olusturma query
    @staticmethod
    def create_and_return_arastirmaci_arastirmaci_baglanti(tx, arastirmaci_adi1, arastirmaci_adi2):
        query = (
            "MATCH (a1:Arastirmaci),(a2:Arastirmaci) "
            "WHERE a1.arastirmaciAdi = $arastirmaci_adi1 AND a2.arastirmaciAdi =$arastirmaci_adi2 "
            "MERGE (a1)-[ortcal:ORTAK_CALISIR]->(a2) "
            "RETURN a1,a2 "
        )
        result = tx.run(query, arastirmaci_adi1=arastirmaci_adi1, arastirmaci_adi2=arastirmaci_adi2)
        try:
            return [{"a1": row["a1"]["arastirmaciAdi"], "a2": row["a2"]["arastirmaciAdi"]}
                    for row in result]
        except ServiceUnavailable as exception:
            logging.error("{query} raised an error: \n {exception}".format(
                query=query, exception=exception))
            raise

    # admini arama
    def find_loginadmin(self, id, pw):
        with self.driver.session() as session:
            result = session.read_transaction(self.find_and_return_loginadmin, id, pw)
            return result

    # admin arama query
    @staticmethod
    def find_and_return_loginadmin(tx, id, pw):
        query = (
            "MATCH (n:Admin{username:$id,password:$pw})"
            "RETURN n.username AS id, n.password AS pw"
        )
        result = tx.run(query, id=id, pw=pw)
        return [{"id": row["id"], "pw": row["pw"]}
                for row in result]

    # kullanicinin girdigi inputu arama fonksiyonlarina yollama fonksiyonu
    def searchFunction(self, searchWord):
        # eger aranan kelime sayiysa yila gore ara
        result_json = []
        if searchWord.isdigit():
            for i in self.find_yayinByYear(int(searchWord)):
                result_json.append(i)
        # sayi degilse arastirmacilarda ve yayinlarda ara
        else:
            for i in self.find_arastirmacinin_yayinlari(searchWord):
                result_json.append(i)
            for i in self.find_yayin(searchWord):
                result_json.append(i)
        return result_json


if __name__ == "__main__":
    # database'e baglanma
    uri = "neo4j+s://276bf72a.databases.neo4j.io"
    user = "neo4j"
    password = "rKG16ozLZOveVMG9NY3JpGl94nfdkJ9Pr6aY6GJ9zYc"
    app = App(uri, user, password)

    aramaString = "Adnan Baysal"  # ornek string
    # arama yapilacak kelimeyi asagidaki fonksiyona yolla(yil girilse bile string olarak yolla)
    print(app.searchFunction(aramaString))

    #####-----ARASTIRMACI OLUSTURMA-----#####
    # arastirmaciAdiString="testARASTIRMACI2"
    # app.create_arastirmaci(arastirmaciAdiString)

    #####-----YAYIN OLUSTURMA-----#####
    # yayinAdiString="testYAYIN"
    # yayinYiliString="2022"
    # app.create_yayin(yayinAdiString,yayinYiliString)

    #####-----TUR OLUSTURMA-----#####
    # yayinTuruString="Makale"
    # yayinYeriString="testDELETELATER"
    # app.create_tur(yayinTuruString,yayinYeriString)

    #####-----ARASTIRMACI-YAYIN BAGLANTISI OLUSTURMA-----#####
    # arastirmaciAdiString="testARASTIRMACI"
    # yayinadiString="testYAYIN"
    # app.create_arastirmaci_yayin_baglanti(arastirmaciAdiString,yayinadiString)

    #####-----YAYIN-YER BAGLANTISI OLUSTURMA-----#####
    # yayinadiString = "testYAYIN"
    # yayinYeriString = "testDELETELATER"
    # app.create_yayin_yer_baglanti(yayinadiString,yayinYeriString)

    #####-----ARASTIRMACI-ARASTIRMACI BAGLANTISI OLUSTURMA-----#####
    # arastirmaciAdiString="testARASTIRMACI"
    # app.create_arastirmaci_arastirmaci_baglanti(arastirmaciAdiString,arastirmaciAdiString2)

    #####-----ADMIN ID PW KONTROL ETME-----#####
    # username="admin"
    # password="admin"
    # app.find_loginadmin(username,password)

    app.close()
