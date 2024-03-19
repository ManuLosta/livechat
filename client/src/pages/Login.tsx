import LoginForm from '../components/LoginForm';

export default function Login() {
  return (
    <div className="grid grid-cols-2 h-screen">
      <div className="bg-gradient-to-tr h-screen w-full  from-cyan-500 to-blue-500"></div>
      <div className="flex flex-col items-center justify-center">
        <h1 className="font-bold text-3xl mb-2">Iniciar sesión</h1>
        <p className="mb-5 text-gray-500 font-light">Ingresa tus datos para iniciar sesión</p>
        <LoginForm />
      </div>
    </div>
  );
}
