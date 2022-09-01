import React, { useState } from "react";
import "../Navbar/styles.css";
import Logo from "../../assets/Logo-principal.png";
import Button from "../../Components/Button";

function Navbar() {
  const [active, setActive] = useState("nav__menu");
  const [icon, setIcon] = useState("nav__toggler");
  const navToggle = () => {
    if (active === "nav__menu") {
      setActive("nav__menu nav__active");
    } else setActive("nav__menu");

    // Icon Toggler
    if (icon === "nav__toggler") {
      setIcon("nav__toggler toggle");
    } else setIcon("nav__toggler");
  };
  return (
    <nav className="nav">
      <a href="/" className="nav__brand">
        <img className="logo" src={Logo} alt="" />
      </a>
      <ul className={active}>
        <li >
          <a href="#" className="nav__link">
            Home
          </a>
        </li>
        <li className="hover">
          <a href="#" className="nav__link">
            Sobre
          </a>
        </li>
        <li className="hover">
          <a href="#" className="nav__link">
            Imóveis
          </a>
        </li>
        <li className="hover">
          <a href="#" className="nav__link">
            Divulgue
          </a>
        </li>
        <li className="hover">
          <a href="#" className="nav__link">
            Consultoria
          </a>
        </li>
        <li className="hover">
          <a href="#" className="nav__link">
            Contato
          </a>
        </li>
        <li>
          <Button />
        </li>
      </ul>
      <div onClick={navToggle} className={icon}>
        <div className="line1"></div>
        <div className="line2"></div>
        <div className="line3"></div>
      </div>
    </nav>
  );
}

export default Navbar;