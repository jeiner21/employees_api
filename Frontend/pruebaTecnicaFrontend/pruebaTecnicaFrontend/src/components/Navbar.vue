<template>
  <nav class="navbar">

    <div class="logo">
      Employees Benefits
    </div>

    <div class="menu">
      <router-link to="/">
        Dashboard
      </router-link>
    </div>

  </nav>
</template>

<style scoped>

.navbar{
    position:fixed;
    top:0;
    left:0;
    width:100%;
    height:70px;
    background:linear-gradient(135deg,#2563eb,#1d4ed8);
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 40px;
    box-shadow:0 5px 15px rgba(0,0,0,.15);
    z-index:1000;
}

.logo{
    color:white;
    font-size:24px;
    font-weight:bold;
}

.menu{
    display:flex;
    align-items:center;
    gap:20px;
}

.menu a{
    color:white;
    text-decoration:none;
    padding:10px 18px;
    border-radius:8px;
    font-weight:bold;
    transition:.3s;
}

.menu a:hover{
    background:rgba(255,255,255,.2);
}

.router-link-active{
    background:white;
    color:#2563eb !important;
}

</style>