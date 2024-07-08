function Home() {
    var username, email, role, loginDt;
    
    if (localStorage != null) {
        username = localStorage.getItem("username");
        email = localStorage.getItem("email");
        role = localStorage.getItem("role");
        loginDt = localStorage.getItem("loginDt");
    }

    return (
        <div className="container card" style={{maxWidth: '350px'}}>
            <h4>로그인정보</h4>
            <div>
                <label className="form-label">
                    {username}
                </label><br />
                <label className="form-label">
                    {email}
                </label><br />
                <label className="form-label">
                    {role}
                </label><br />
                <label className="form-label">
                    {loginDt}
                </label>

            </div>
        </div>
    );
}

export default Home;