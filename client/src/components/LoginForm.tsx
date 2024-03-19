import { Button, Input } from '@nextui-org/react';
import { Eye, EyeOff } from 'lucide-react';
import { useState } from 'react';

export default function LoginForm() {
  const [isVisible, setIsVisible] = useState(false);

  const toggleVisibility = () => {
    setIsVisible(!isVisible);
  };

  return (
    <div className="flex flex-col gap-5 min-w-[350px]">
      <Input type="text" label="Usuario" />
      <Input
        label="Contraseña"
        type={!isVisible ? 'text' : 'password'}
        endContent={
          <button className="pe-2 focused:outline-none focus:ring-0" onClick={() => toggleVisibility()}>
            {isVisible ? <Eye /> : <EyeOff />}
          </button>
        }
      />
      <Button color="primary">Iniciar sesión</Button>
    </div>
  );
}
