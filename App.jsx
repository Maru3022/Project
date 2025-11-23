import React from 'react'
import Sidebar from './components/Sidebar'
import Dashboard from './components/Dashboard'
import BookCatalog from './components/BookCatalog'


const navItems = [
    { name: 'Обзор', component: Dashboard },
    { name: 'Каталог Книг', component: BookCatalog },
    { name: 'Читатели', component: () => <div>Читатели — заглушка</div> },
    { name: 'Отчеты', component: () => <div>Отчеты — заглушка</div> },
    { name: 'Настройки', component: () => <div>Настройки — заглушка</div> },
]


export default function App() {
    const [currentView, setCurrentView] = React.useState('Обзор')
    const CurrentComponent = navItems.find(item => item.name === currentView)?.component || Dashboard


    return (
        <div className="flex min-h-screen">
            <Sidebar navItems={navItems} currentView={currentView} setView={setCurrentView} />


            <main className="flex-1 p-8 overflow-y-auto">
                <header className="mb-8">
                    <h2 className="text-4xl font-bold text-gray-800">{currentView}</h2>
                </header>


                <CurrentComponent />
            </main>
        </div>
    )
}