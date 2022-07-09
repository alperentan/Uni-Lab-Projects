from flask import Flask ,render_template ,redirect,url_for
from flask import request
from markupsafe import escape
app = Flask(__name__)

@app.route('/user/<username>')
def show_user_profile(username):
    # show the user profile for that user
    return f'User {escape(username)}'

app.run()