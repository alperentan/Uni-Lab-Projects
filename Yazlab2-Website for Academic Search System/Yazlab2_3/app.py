from flask import Flask, render_template, redirect, url_for
from flask import request

from main import App

app = Flask(__name__)
uri = "neo4j+s://276bf72a.databases.neo4j.io"
user = "neo4j"
password = "rKG16ozLZOveVMG9NY3JpGl94nfdkJ9Pr6aY6GJ9zYc"
neofj = App(uri, user, password)
exist_user = False
keyword = ""


@app.route("/homepage")
def home():
    global exist_user
    return render_template('homepage.html', context={'user_situation': exist_user})


@app.route("/", methods=['GET', 'POST'])
def index():
    global exist_user
    global neofj
    global keyword
    query_result = []
    error = None
    if request.method == 'POST':
        if (request.form['search'] == ''):
            error = "Form can not be empyt ... "
        else:
            query_result = neofj.searchFunction(request.form['search'])
            print(query_result)
            # Arama sorgusu burda yapılcak
    return render_template('index.html', error=error, context={'user_situation': exist_user}, result=query_result)


@app.route('/login', methods=['GET', 'POST'])
def login():
    global exist_user
    error = None
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
        result = neofj.find_loginadmin(username, password)
        if len(result) == 0:
            error = 'Invalid Credentials. Please try again.'
        else:
            exist_user = True
            return redirect(url_for('home'))
    return render_template('login.html', error=error, context={'user_situation': exist_user})


@app.route('/addinfo', methods=['GET', 'POST'])
def adddata():
    global exist_user
    global neofj
    error = None
    success = None
    if request.method == 'POST':
        writer_name = request.form["researchname"]
        paper_name = request.form["papername"]
        pub_year = request.form["publishyear"]
        pub_type = request.form["publishtype"]
        pub_place = request.form["publishplace"]
        writer_list = writer_name.split("-")

        for i in writer_list:
            neofj.create_arastirmaci(i)

        neofj.create_yayin(paper_name, pub_year)

        neofj.create_tur(yayin_turu=pub_type, yayin_yeri=pub_place)

        for i in writer_list:
            neofj.create_arastirmaci_yayin_baglanti(i, paper_name)

        neofj.create_yayin_yer_baglanti(paper_name, pub_place)

        for i in writer_list:
            for j in writer_list:
                if i != j:
                    neofj.create_arastirmaci_arastirmaci_baglanti(i, j)
        success = "Paper Successfully Added"
    else:
        error = 'Error occurs'
    return render_template('addform.html', error=error, success=success, context={'user_situation': exist_user})


@app.route('/logout')
def logout():
    global exist_user
    exist_user = False
    return redirect(url_for('index'))


@app.route('/table/<name>')
def showtable(name):
    global exist_user
    query_result = None
    render_template('relation.html', name=name, context={'user_situation': exist_user, 'result': query_result})


@app.route('/graph')
def showgraph():
    global exist_user
    query_result = None
    global keyword
    return render_template('graph.html', context={'user_situation': exist_user}, keyword=keyword)


app.run()
