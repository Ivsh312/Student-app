from selenium import webdriver  # работа с браузером
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import Firefox
from selenium.webdriver.support.ui import WebDriverWait  # ожидания различных событий
from selenium.webdriver.support.ui import Select  # работа со списками
from selenium.webdriver.common.action_chains import ActionChains  # различные действия
from selenium.webdriver.common.by import By
import unittest

class VkAutorisation():
    def test_vkiN():
        url = 'http://google.ru/'
        driver = Firefox()
        driver.get(url)
        element = driver.find_element_by_name('q')  # ищем элемент для ввода нашего текста.
        element.send_keys('mail.ru')
        element.send_keys(Keys.ENTER)
        driver.implicitly_wait(3)
        href = driver.find_element_by_class_name("LC20lb")
        href.click()
        driver.implicitly_wait(12)
        login_element = driver.find_element_by_name('n290231777')
        login_element.click()
        driver.close()
        # login_element.send_keys('lol')
        # pass_element = driver.find_element_by_name('email')
        # pass_element.send_keys('lol')

    if __name__ == '__main__':
        pytest.main('test_VkAutorisation.py')
